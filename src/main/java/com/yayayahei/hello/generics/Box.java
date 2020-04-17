package com.yayayahei.hello.generics;

public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass());
        System.out.println("U: " + u.getClass());
    }

    protected Class<Long> dataType() {
        return Long.class;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(10l); // error: this is still String!
        System.out.println("dataType: " + integerBox.dataType());
    }
}
