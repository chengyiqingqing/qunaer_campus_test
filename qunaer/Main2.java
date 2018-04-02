package com.wenwen.swordtooffer.qunaer;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2018/4/1.
 */

public class Main2 {
    //使用栈的方式可以吗
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Tree tree=new Tree();
        while(scanner.hasNextLine()){
            Stack<Node> stack=new Stack<>();
            stack.push(tree.node1);
            String str=scanner.nextLine();
            char[] charArr = str.toCharArray();
            for(int i=0;i<charArr.length;i++){
                Node curNode=stack.peek();
                if(charArr[i]=='L'){  //左边的；
                    stack.push(curNode.left);
                }else if(charArr[i]=='R'){//右边的；
                    stack.push(curNode.right);
                }else{//直接找父节点；
                    if(stack.size()>1){//!stack.isEmpty()  就剩一个的时候，没有父节点；
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty())
                System.out.println(stack.peek().v);
        }
    }

    static class Node {
        public int v;
        public Node left;
        public Node right;
    }

    static class Tree {
        public Node node1;
        public Node node2;
        public Node node3;
        public Node node4;
        public Node node5;

        public Tree() {
            node1 = new Node();
            node2 = new Node();
            node3 = new Node();
            node4 = new Node();
            node5 = new Node();

            node1.v = 1;
            node1.left = node2;
            node1.right = node3;

            node2.v = 2;
            node2.left = node3;
            node2.right = node4;

            node3.v = 3;
            node3.left = node4;
            node3.right = node5;

            node4.v = 4;
            node4.left = node5;
            node4.right = node1;

            node5.v = 5;
            node5.left = node1;
            node5.right = node2;

        }
    }

}
