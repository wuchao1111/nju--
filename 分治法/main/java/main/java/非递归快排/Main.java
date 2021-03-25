package main.java.非递归快排;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description
 * 快速排序的核心思想是使用元素的值对数组进行划分。实现其非递归方案。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i]=s.nextInt();
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<n;i++){
            if(i==0)
                System.out.print(nums[i]);
            else
                System.out.print(" "+nums[i]);
        }
    }

    //递归写法
//    public static void quickSort(int[] nums,int start,int end){
//        if(start>=end)
//            return ;
//        int part = partition(nums,start,end);
//        quickSort(nums,start,part-1);
//        quickSort(nums,part+1,end);
//    }

    //非递归写法
    public static void quickSort(int[]nums,int start,int end){
        Stack<Integer>stack = new Stack<>();
        stack.push(start);
        stack.push(end);
        while(!stack.isEmpty()){
            end = stack.pop();
            start = stack.pop();
            int i = partition(nums, start,end );
            if(start<i-1) {
                stack.push(start);
                stack.push(i - 1);
            }
            if(i+1<end) {
                stack.push(i + 1);
                stack.push(end);
            }
        }
    }

    public static int partition(int[] nums,int i,int j){
        int key = nums[i];
        while(i<j){
            while(i<j&&nums[j]>=key)
                j--;
            nums[i]=nums[j];
            while(i<j&&nums[i]<=key)
                i++;
            nums[j]=nums[i];
        }
        nums[i]=key;
        return i;
    }
}
