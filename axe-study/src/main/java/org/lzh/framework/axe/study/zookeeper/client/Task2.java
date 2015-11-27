//package org.lzh.framework.axe.study.zookeeper.client;
//
//
//
//import org.apache.zookeeper.data.Stat;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Description:
// * @author: lizhaohua
// * @date: 15/11/26 下午2:41
// * @version: V1.0
// */
////分布式锁实现分布式seq生成
//public  class Task2 implements Runnable, IZkChildListener {
//    private static final String LOCK_ZNODE ="" ;
//    private final String taskName;
//    private final ZkClient zkClient;
//    private final String lockPrefix = "/loc";
//    private final String selfZnode;
//    public Task2(String taskName) {
//        this.taskName = taskName;
//        zkClient = new ZkClient("127.0.0.1:2181", 30000, 10000);
//        selfZnode = zkClient.createEphemeralSequential(LOCK_ZNODE + lockPrefix, new byte[0]);
//    }
//    @Override
//    public void run() {
//        zkClient.subscribeChildChanges(LOCK_ZNODE, this);
//        do {
//        } while (zkClient.isConnected());
//    }
//    private void createSeq() {
//        Stat stat = new Stat();
//        byte[] oldData = zkClient.readData(LOCK_ZNODE, stat);
//        byte[] newData = update(oldData);
//        zkClient.writeData(LOCK_ZNODE, newData);
//        System.out.println(taskName + selfZnode + " obtain seq=" + new String(newData));
//    }
//    private byte[] update(byte[] currentData) {
//        String s = new String(currentData);
//        int d = Integer.parseInt(s);
//        d = d + 1;
//        s = String.valueOf(d);
//        return s.getBytes();
//    }
//    @Override
//    public void handleChildChange(String parentPath, List<String> currentChildren) throws Exception {
//        String[] childrensZnode = currentChildren.toArray(new String[currentChildren.size()]);
//        Arrays.sort(childrensZnode);
//        String minZnode = LOCK_ZNODE + "/" + childrensZnode[0];
//        if (selfZnode.equals(minZnode)) {
//            createSeq();
//            zkClient.unsubscribeChildChanges(LOCK_ZNODE, this);
//            zkClient.delete(selfZnode);
//            zkClient.close();
//        }
//    }
//}