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
    public void doJob(){
        System.out.println("不继承QuartzJobBean方式-调度进行中..."+
                StringUtils.dateFormat(new Date())+
                "==>name:"+Thread.currentThread().getName()+
                " ==>threadId:"+Thread.currentThread().getId());
    }
}
