package com.wenwen.swordtooffer.qunaer;

/**
 * Created by Administrator on 2018/4/2.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //当有输入的时候；
        while (sc.hasNext()) {
            //1.输入一行数字，并劈开；
            String str = sc.nextLine();
            String[] strs = str.split("\\s+");
            int n = strs.length;
            int num[] = new int[n];
            Queue<Integer> q = new LinkedList<Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(strs[i], 16);
                System.out.print(" "+num[i]);
                list.add(num[i]);
            }
            System.out.println();
            q.offer(num[0]);
            list.remove(Integer.valueOf(num[0]));
            while (!q.isEmpty()) {
                int temp = q.poll();
                if (list.contains(temp + 1)) {
                    q.offer(temp + 1);
                    list.remove(Integer.valueOf(temp + 1));
                }
                if (list.contains(temp - 1)) {
                    q.offer(temp - 1);
                    list.remove(Integer.valueOf(temp - 1));
                }
                if (list.contains(temp + 4)) {
                    q.offer(temp + 4);
                    list.remove(Integer.valueOf(temp + 4));
                }
                if (list.contains(temp - 4)) {
                    q.offer(temp - 4);
                    list.remove(Integer.valueOf(temp - 4));
                }
            }
            if (list.isEmpty())
                System.out.println("pong");
            else
                System.out.println("pang");
        }
    }
}

