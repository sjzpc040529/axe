package org.lzh.framework.axe.study.zookeeper.client;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Description:利用zookeeper
 * @author: lizhaohua
 * @date: 15/11/26 下午1:48
 * @version: V1.0
 */
public class ZookeeperClient {
        public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
            ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 300000, new DemoWatcher());//连接zk server
            String node = "/orderSeq";
            Stat stat = zk.exists(node, false);//检测/orderSeq是否存在
            if (stat == null) {
                //创建节点
                System.out.println("create node name orderSeq");
                String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println(createResult);
                System.out.println("stat:"+stat.getAversion());


            }
            //获取节点的值
            byte[] b = zk.getData(node, false, stat);
            System.out.println(new String(b));
            System.out.println("end stat:"+stat.getAversion());
            zk.close();
        }

        static class DemoWatcher implements Watcher {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("----------->");
                System.out.println("path:" + event.getPath());
                System.out.println("type:" + event.getType());
                System.out.println("stat:" + event.getState());
                System.out.println("<-----------");
            }
        }
    }