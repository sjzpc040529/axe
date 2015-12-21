package org.lzh.framework.axe.study.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Description:目标方法成功调用返回结果后实现切面增强
 * @author: lizhaohua
 * @date: 15/12/14 下午9:37
 * @version: V1.0
 */
public class CountingAfterReturningAdvice extends MethodCounter implements AfterReturningAdvice {

    public void afterReturning(Object o, Method m, Object[] args, Object target) throws Throwable {
        count(m);
    }


}