package org.lzh.framework.axe.study.quartz;

/**
 * @Description: 继承QuartzJobBean
 * @author: lizhaohua
 * @date: 15/11/18 上午11:30
 * @version: V1.0
 */
import org.lzh.framework.util.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class Job2 extends QuartzJobBean {

    private int timeout;
    private static int i = 0;
    //调度工厂实例化后，经过timeout时间开始执行调度
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * 要调度的具体任务
     */
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("继承QuartzJobBean方式-调度进行中..."+
                StringUtils.dateFormat(new Date())+
                "==>name:"+Thread.currentThread().getName()+
                " ==>threadId:"+Thread.currentThread().getId());
    }
}