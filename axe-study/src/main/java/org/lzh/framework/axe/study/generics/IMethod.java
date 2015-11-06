package org.lzh.framework.axe.study.generics;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/3 上午11:39
 * @version: V1.0
 */
public interface IMethod {
    public <T> void write(T t, T[] ta);

}
