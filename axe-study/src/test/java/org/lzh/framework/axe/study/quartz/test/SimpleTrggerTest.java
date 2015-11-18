package org.lzh.framework.axe.study.quartz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring SimpleTriggerBean 触发器
 * <ul>
 *    <li>每<b>隔</b>指定时间则触发一次</li>
 * </ul>
 *
 * @author: lizhaohua
 * @date: 15/11/18 上午11:06
 * @version: V1.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:quartz-simple.xml")
public class SimpleTrggerTest {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("quartz-simple.xml");
    }
}
