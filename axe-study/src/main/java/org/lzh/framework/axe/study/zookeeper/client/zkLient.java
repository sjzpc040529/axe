package org.lzh.framework.axe.study.zookeeper.client;

import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/26 下午2:13
 * @version: V1.0
 */
public class zkLient {
    @Test
    public void testZkClient() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        String node = "/seq";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "1");
        }
        System.out.println(zkClient.readData(node));
        node="/lock";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "1");
        }
        System.out.println(zkClient.readData(node));
    }
}
