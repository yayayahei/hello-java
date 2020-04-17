package com.yayayahei.hello.types;


public class ConvertStringToDouble {

    public static void main(String[] args) {
        String price = "1,549";
        // this will throw java.lang.NumberFormatException
        Double priceInDouble = Double.valueOf(price);
        System.out.println(priceInDouble);
    }
}
