package org.lzh.framework.axe.study.generics.blog;

import java.util.Date;

public interface Show<T,U>{
    void show(T t,U u);
}

class ShowTest implements Show<String,Date>{
    @Override
    public void show(String str,Date date) {
        System.out.println(str);
        System.out.println(date);
    }

//    public static void main(String[] args)  {
//        ShowTest showTest=new ShowTest();
//        showTest.show("Hello",new Date());
//    }

    public static void main(String[] args) throws ClassNotFoundException {
        String str=get("Hello", null);
        System.out.println(str);
    }

    public static <T, U> T get(T t, U u) {
        if (u != null)
            return t;
        else
            return null;
    }
}