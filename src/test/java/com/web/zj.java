package com.web;

import java.util.*;

public class zj {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5};
        int i = Minimumdays(3, arr);
        System.out.println(i);
        int[] arr1 = new int[]{7,3};
        int j = Minimumdays(2, arr1);
        System.out.println(j);
    }
    public static int Minimumdays (int n, int[] DEF) {
        // write code here
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (count >= DEF[i]){
                count++;
            }else {
                while (count < DEF[i]){
                    count++;
                }
            }

        }
        return count - 1;

    }
}
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = n - 1;i < s.length();i++){
            builder.append(chars[i]);
        }
        for (int i = 0; i < n;i++){
            builder.append(chars[i]);
        }
        String string = builder.toString();
        return string;
    }
}
