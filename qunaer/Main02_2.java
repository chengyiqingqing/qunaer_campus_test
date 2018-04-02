package com.wenwen.swordtooffer.qunaer;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/2.
 */

public class Main02_2 {

    public static void main(String[] args){
        //只是给他去加上注释就行了；看下整体思路。
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            //1.根据输入的第一行的长度；初始化空的array[row][row];
            String string = scanner.nextLine();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c != ' ') {
                    count++;
                }
            }
            //2.再根据第一行的数据，初始化array[0][k]；    0<=k，k<row;
            int[][] arr = new int[count][count];
            int k = 0;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c != ' ') {
                    arr[0][k] = Integer.parseInt(String.valueOf(c));
                    k++;
                }
            }
            //3.就直接来两个for循环，scanner.nextInt();依次初始化剩余的数据；
            for (int i = 1; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            //4.就是一个search方法区寻找最短路径。
            search(arr, 0, 0);
            if (min == 0) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }
        }
    }

    private static int min = 0;
    private static int temp = 0;

    /**
     * 从row,col开始找最短路径。
     * @param arr 二维数组；
     * @param row 从哪一行开始；
     * @param col 从哪一行结束；
     */
    private static void search(int[][] arr, int row, int col) {

        if (row >= arr.length || col >= arr.length || row < 0 || col < 0) {
            return;
        }
        if (row == arr.length - 1 && col == arr.length - 1) {
            if (min == 0) {
                min = temp;
            } else {
                if (temp < min) {
                    min = temp;
                }
            }
            return;
        }
        if (arr[row][col] == 0) {
            temp++;
            arr[row][col] = 1;
            search(arr, row - 1, col);
            search(arr, row + 1, col);
            search(arr, row, col - 1);
            search(arr, row, col + 1);
            temp--;
            arr[row][col] = 0;
        }
    }


}
