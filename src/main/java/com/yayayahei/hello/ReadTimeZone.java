package com.yayayahei.hello;

import java.util.TimeZone;

public class ReadTimeZone {
    public static void main(String[] args) {
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String id : availableIDs) {
            TimeZone timeZone = TimeZone.getTimeZone(id);
            System.out.println(timeZone.getID()+": " + timeZone.getDisplayName());
        }
    }
}
