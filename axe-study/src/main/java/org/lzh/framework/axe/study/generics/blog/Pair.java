package org.lzh.framework.axe.study.generics.blog;

public class Pair<T> {
    private T value;
    public Pair(T value) {
                  this.value=value;
             }
           public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Pair<String> pair=new Pair<String>("Hello");
        String str=pair.getValue();
        System.out.println(str);
        pair.setValue("World");
        str=pair.getValue();
        System.out.println(str);
    }
}