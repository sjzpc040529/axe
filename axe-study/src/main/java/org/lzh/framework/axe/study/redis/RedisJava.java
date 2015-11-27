package org.lzh.framework.axe.study.redis;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/26 下午5:21
 * @version: V1.0
 */

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisJava {
    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("Connection to server sucessfully");
//        //设置 redis 字符串数据
//        jedis.set("w3ckey", "Redis tutorial");
//        // 获取存储的数据并输出
//        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
//
//        //连接本地的 Redis 服务
////        Jedis jedis = new Jedis("localhost");
////        System.out.println("Connection to server sucessfully");
////        //存储数据到列表中
//        jedis.lpush("tutorial-list", "Redis");
//        jedis.lpush("tutorial-list", "Mongodb");
//        jedis.lpush("tutorial-list", "Mysql");
//        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
//
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("Stored string in redis:: "+list.get(i));
//        }
//
//    }



        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
System.out.println(jedis.incr("seq"));
System.out.println(jedis.incr("another_seq"));
System.out.println(jedis.incr("orderSeq"));
System.out.println(jedis.del("orderSeq"));
        // 获取数据并输出
        Set<String> list = jedis.keys("*");
       Iterator it =  list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}