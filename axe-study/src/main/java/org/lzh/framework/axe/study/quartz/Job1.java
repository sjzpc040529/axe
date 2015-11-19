package org.lzh.framework.axe.study.quartz;

import org.lzh.framework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:任务类 不继承QuartzJobBean
 * @author: lizhaohua
 * @date: 15/11/16 下午3:37
 * @version: V1.0
 */
public class Job1 implements Serializable {
    public void doJob() throws InterruptedException {
        System.out.println("不继承QuartzJobBean方式-调度进行中..."+
                StringUtils.dateFormat(new Date())+
                "==>name:"+Thread.currentThread().getName()+
                " ==>threadId:"+Thread.currentThread().getId());
        Thread.sleep(1000);
//        if(Integer.parseInt(Thread.currentThread().getName().split("-")[1])%2==0){
//            data2(Thread.currentThread().getName());
//        }else {
//            data1(Thread.currentThread().getName());
//        }

    }

    private String data1(String name){
        System.out.println(name+"单数");
        return null ;
    }

    private void data2(String name){
        System.out.println(name+"双数");
    }
}
