package org.lzh.framework.axe.study.zookeeper.client;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/26 下午2:59
 * @version: V1.0
 */
import com.github.zkclient.IZkChildListener;
import com.github.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author : secondriver
 */
public class GenerateSeq {

    //提前创建好存储Seq的"/createSeq"结点 CreateMode.PERSISTENT
    public static final String SEQ_ZNODE = "/seq";

    //提前创建好锁对象的结点"/lock" CreateMode.PERSISTENT
    public static final String LOCK_ZNODE = "/lock";

    public static void main(String[] args) {

        final ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            service.execute(new Task2("[Concurrent-" + i + "]"));
        }

        if (!service.isShutdown()) {
            try {
                service.shutdown();
                if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                    service.shutdownNow();
                }
            } catch (InterruptedException e) {
                service.shutdownNow();
                System.out.println(e.getMessage());
            }
        }
    }

    public static class Task1 implements Runnable {

        private final String taskName;

        public Task1(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            ZkClient zkClient = new ZkClient("127.0.0.1:2181", 3000, 1000);
            Stat stat = zkClient.writeData(SEQ_ZNODE, new byte[0], -1);
            int versionAsSeq = stat.getVersion();
            //versionAsSeq 最终的序列号
            System.out.println(taskName + " obtain seq=" + versionAsSeq);
//            System.out.println("1"+new String(zkClient.readData(SEQ_ZNODE)));
            zkClient.close();
        }
    }

    //分布式锁实现
    public static class Task2 implements Runnable, IZkChildListener {

        private final String taskName;

        private final ZkClient zkClient;

        private final String lockPrefix = "/loc";

        private final String selfZnode;

        public Task2(String taskName) {
            this.taskName = taskName;
            zkClient = new ZkClient("127.0.0.1:2181", 30000, 10000);
            selfZnode = zkClient.createEphemeralSequential(LOCK_ZNODE + lockPrefix, new byte[0]);
        }

        @Override
        public void run() {
            zkClient.subscribeChildChanges(LOCK_ZNODE, this);
            do {
            } while (zkClient.isConnected());
        }


        private void createSeq() {
            Stat stat = new Stat();
            byte[] oldData = zkClient.readData(LOCK_ZNODE, stat);
            byte[] newData = update(oldData);
            zkClient.writeData(LOCK_ZNODE, newData);
            //new String(newData) 最终的序列号
            System.out.println(taskName + selfZnode + " obtain seq=" + new String(newData));
        }

        private byte[] update(byte[] currentData) {
            String s = new String(currentData);
            int d = Integer.parseInt(s);
            d = d + 1;
            s = String.valueOf(d);
            return s.getBytes();
        }

        @Override
        public void handleChildChange(String parentPath, List<String> currentChildren) throws Exception {
            String[] childrensZnode = currentChildren.toArray(new String[currentChildren.size()]);
            Arrays.sort(childrensZnode);
            String minZnode = LOCK_ZNODE + "/" + childrensZnode[0];
            if (selfZnode.equals(minZnode)) {
                createSeq();
                zkClient.unsubscribeChildChanges(LOCK_ZNODE, this);
                zkClient.delete(selfZnode);
                zkClient.close();
            }
        }
    }
}