package org.lzh.framework.axe.study.generics.blog;

public class Test2{
    public static void main(String[] args) {
        /**不指定泛型的时候*/
        int i=Test2.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f=Test2.add(1, 1.2);//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o=Test2.add(1, "asd");//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

      /**指定泛型的时候*/
        int a=Test2.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类
//        int b=Test2.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float
        Number c=Test2.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }
}