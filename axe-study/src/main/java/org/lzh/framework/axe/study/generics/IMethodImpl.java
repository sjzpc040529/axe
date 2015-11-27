package org.lzh.framework.axe.study.generics;


import org.lzh.framework.common.util.Printer;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/3 上午11:39
 * @version: V1.0
 */
public class IMethodImpl  implements IMethod{
    public <T> void write(T t, T[] ta) {
        Printer.println(t);
        Printer.println(ta);
    }
}
