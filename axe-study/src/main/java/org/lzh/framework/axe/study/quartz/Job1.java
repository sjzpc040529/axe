package org.lzh.framework.axe.study.quartz;

import org.lzh.framework.util.StringUtils;

import java.util.Date;

/**
 * @Description:任务类
 * @author: lizhaohua
 * @date: 15/11/16 下午3:37
 * @version: V1.0
 */
public class Job1 {
    public void doJob(){
        System.out.println("不继承QuartzJobBean方式-调度进行中..."+ StringUtils.dateFormat(new Date()));
    }
}
