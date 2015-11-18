package org.lzh.framework.axe.study.quartz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/18 下午12:03
 * @version: V1.0
 */
public class SpringTaskJobTest {
    public static void main(String[] arg0){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-task.xml");
    }
}
