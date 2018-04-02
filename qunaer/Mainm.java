package com.wenwen.swordtooffer.qunaer;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/2.
 */

public class Mainm {

    static String target;
    static int countSum=0;
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        for (int i=0;i<str.length();i++){
            target+=str.substring(str.length()-i-1,str.length()-i);
        }
        String[] strArr=scanner.nextLine().split(" ");
        HashSet<String> hashSet=new HashSet<>();
        for (String string:strArr){
            hashSet.add(string);
        }
        for (String string:hashSet){
            if (compares(str,string)){
                System.out.println(countSum);
                return;
            }
        }
        //hot
        //doh got dot god tod dog lot log
        System.out.println(-1);
    }

    public static boolean compares(String str1,String str2){
        int count=0;
        for (int i=0;i<str1.length();i++){
            if (str1.charAt(i)!=str2.charAt(i)){
                count++;
            }
        }
        if (count==1){
            countSum++;
            str1=str2;
        }
        if (target==str1){
            return true;
        }else {
            return false;
        }
    }


}
