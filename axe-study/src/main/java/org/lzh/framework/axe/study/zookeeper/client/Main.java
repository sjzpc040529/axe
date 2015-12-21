package org.lzh.framework.axe.study.zookeeper.client;

import org.apache.zookeeper.*;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/12/17 下午2:07
 * @version: V1.0
 */
public class Main {
    public static void main(String[] arg0) throws Exception {
        //创建一个Zookeeper实例，第一个参数为目标服务器地址和端口，第二个参数为Session超时时间，第三个为节点变化时的回调方法
        ZooKeeper zk = new ZooKeeper("127.0.0.1:12181", 500000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                //dosomething
            }
        });

//创建一个节点root，数据是mydata,不进行ACL权限控制，节点为永久性的(即客户端shutdown了也不会消失)
//        zk.create("/root", "mydata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//在root下面创建一个childone znode,数据为childone,不进行ACL权限控制，节点为永久性的
//        zk.create("/root/childone", "childone".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//取得/root节点下的子节点名称,返回List<String>
//        zk.getChildren("/root", true);

//取得/root/childone节点下的数据,返回byte[]
//        zk.getData("/root/childone", true, null);

//修改节点/root/childone下的数据，第三个参数为版本，如果是-1，那会无视被修改的数据版本，直接改掉
//        zk.setData("/root/childone", "childonemodify".getBytes(), -1);

//删除/root/childone这个节点，第二个参数为版本，－1的话直接删除，无视版本
//        zk.delete("/root/childone", -1);

//        System.out.println(new String(zk.getData("/APP1",true,null)));
//        zk.create("/testRootPath/testChildPath1","1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//
//        zk.create("/testRootPath/testChildPath2","2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//
//        zk.create("/testRootPath/testChildPath3","3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//
//// 创建一个子目录节点
//        zk.create("/testRootPath/testChildPath4","4".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//
        System.out.println(zk.getChildren("/testRootPath", true));
//        zk.create("/testRootPath2", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//// 创建一个子目录节点
//        zk.create("/testRootPath2/testChildPath1","1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
//
//        zk.create("/testRootPath2/testChildPath2","2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
//
//        zk.create("/testRootPath2/testChildPath3","3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
//
//// 创建一个子目录节点
//        zk.create("/testRootPath2/testChildPath4","4".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
//
//        System.out.println(zk.getChildren("/testRootPath", false));
//关闭session
        zk.close();
    }
}
