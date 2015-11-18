package org.lzh.framework.axe.study.quartz;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/18 上午11:55
 * @version: V1.0
 */
import org.springframework.stereotype.Service;
@Service
public class TaskJob {

    public void job() {
        System.out.println("spring task job...");
    }
}