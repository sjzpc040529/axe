package org.lzh.framework.axe.study.zookeeper.client;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/26 下午2:35
 * @version: V1.0
 */
public class ZkSeq {
    //提前创建好存储Seq的"/createSeq"结点 CreateMode.PERSISTENT
    public static final String SEQ_ZNODE = "/orderSeq";
    //通过znode数据版本实现分布式seq生成
    public static class Task1 implements Runnable {
        private final String taskName;
        public Task1(String taskName) {
            this.taskName = taskName;
        }
        @Override
        public void run() {
            ZkClient zkClient = new ZkClient("127.0.0.1:2181", 3000, 1000);
            zkClient.writeData(SEQ_ZNODE, new byte[0], -1);
//            int versionAsSeq = stat.getVersion();
//            System.out.println(taskName + " obtain seq=" + versionAsSeq);
            zkClient.close();
        }
    }
    //main
    public static void  main(String[] arg0){
        final ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            service.execute(new Task1("[Concurrent-" + i + "]"));
        }
    }

}
