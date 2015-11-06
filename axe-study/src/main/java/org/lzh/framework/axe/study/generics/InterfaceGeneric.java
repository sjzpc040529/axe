package org.lzh.framework.axe.study.generics;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/4 上午11:46
 * @version: V1.0
 */
public interface InterfaceGeneric<E> {
    public E getE();
    public void save(E e);
}