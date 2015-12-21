package org.lzh.framework.axe.study.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description:完成被调用方法次数的统计,目标方法在调用之前实现切面增强
 * @author: lizhaohua
 * @date: 15/12/14 下午9:16
 * @version: V1.0
 */
public class CountingBeforeAdvice extends MethodCounter implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        count(method);
    }
}
