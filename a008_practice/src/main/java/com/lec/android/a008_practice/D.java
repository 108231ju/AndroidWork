package com.lec.android.a008_practice;

public class D {

    public static final String [] NAME = {


    };

    public static final String [] AGE = {


    };

    public static final String [] ADDRESS = {


    };

    private static int idx = 0;

    public static int next(){
        idx = idx % NAME.length;
        return idx++;   // idx 값 리턴하고 1증가
    }
}
