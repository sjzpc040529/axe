package org.lzh.framework.axe.study.aop;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Description:方法统计者
 * @author: lizhaohua
 * @date: 15/12/14 下午9:18
 * @version: V1.0
 */
public class MethodCounter implements Serializable {
    /**map存储方法名称和调用次数的映射*/
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    //所有的调用次数
    private int allCount;


    /**
     * CountingBeforeAdvice 输入
     * 设置方法调用次数
     * @param m
     */
    protected void count(Method m) {
        count(m.getName());
    }

    protected void count(String methodName) {
        Integer i = map.get(methodName);
        i = (i != null) ? new Integer(i.intValue() + 1) : new Integer(1);
        map.put(methodName, i);
        ++allCount;
    }

    /**
     * 更具方法名称获取调用次数
     * @param methodName
     * @return
     */
    public int getCalls(String methodName) {
        Integer i = map.get(methodName);
        return (i != null ? i.intValue() : 0);
    }

    /**
     * 返回所有方法的总调用次数
     * @return
     */
    public int getCalls() {
        return allCount;
    }

    /**
     * A bit simplistic: just wants the same class.
     * Doesn't worry about counts.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        return (other != null && other.getClass() == this.getClass());
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
