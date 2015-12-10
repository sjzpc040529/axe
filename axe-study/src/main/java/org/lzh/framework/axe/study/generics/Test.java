package org.lzh.framework.axe.study.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/12/9 下午4:28
 * @version: V1.0
 */
public class Test {
    void printList(List<?> l) {
        for (Object o : l)
            System.out.println(o);
    }
    public <T> T ifThenElse(boolean b, T first, T second) {
        return b ? first : second;
    }
    public static  void main(String...strings){
        Test test = new Test();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        test.printList(list);

        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(42));
        List<?> lu = li;
//       lu.add(2);
        System.out.println(lu.get(0));
        System.out.println(test.ifThenElse(true,"true","false"));
    }
}
