package com.wenwen.swordtooffer.qunaer;

import java.util.Scanner;

/**
 * Created by sww on 2018/4/2.
 */

public class Main {

    static int[] ori = null;
    static int[] temp = null;
    static final int N = 3;
    static int sums=101;
    static boolean it=false;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        sums=scanner.nextInt();
        ori=new int[num];
        for (int i=0;i<num;i++){
            ori[i]=scanner.nextInt();
        }
        temp = new int[num];
        int sum=0;
        for (int i=0;i<num;i++){
            sum+=ori[i];
        }
        if (sum==sums){
            System.out.println("perfect");
            return;
        }
        for (int i=0;i<num;i++){
            if (ori[i]==sums){
                System.out.println("perfect");
                return;
            }
        }
        for (int i=2;i<=num-1;i++){
            reCombine(ori.length,i);
        }
        if (!it)
            System.out.println("good");
    }
//5 100
    //10 20 30 40 50
    private static void reCombine(int n,int r){  //对数组进行重排；
        if (it)
            return;
        if (n<r){
            return;
        }else if (r==0){//这里是得出了一个temp的组合。
            int sum=0;
            for (int i=0;i<N;i++){
                sum+=temp[i];
            }
            if (sum==sums){
                it=true;
                System.out.println("perfect");
                return;
            }
        }else{
            if (!it){
                reCombine(n-1,r);
                if (it){
                    return;
                }
                temp[r-1]=ori[n-1];
                if (it){
                    return;
                }
                reCombine(n-1,r-1);
            }else {
                return;
            }

        }
    }


}
