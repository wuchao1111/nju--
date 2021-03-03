package main.java.非递归合并排序;

import java.util.Scanner;
import java.util.Stack;

/**
 Description
 合并（归并）排序的核心思想是：每次从中间位置将数组分组再分别排序。请实现其非递归方案。


 Input
 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。


 Output
 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();
        mergeSort(nums, 0,nums.length - 1, temp);
        for (int i = 0; i < n; i++) {
            if (i == 0)
                System.out.print(nums[i]);
            else
                System.out.print(" " + nums[i]);
        }
    }

//    递归写法
//    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
//        if(left>=right)
//            return ;
//        int mid = left+(right-left)/2;
//        mergeSort(nums,left,mid,temp);
//        mergeSort(nums,mid+1,right,temp);
//        if(nums[mid]>nums[mid+1])
//            merge(nums,left,mid,right,temp);
//    }
//    非递归写法
    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        Stack<Integer>s = new Stack<>();
        Stack<Integer>s2 = new Stack<>();
        s.push(left);
        s.push(right);
        s2.push(left);
        s2.push(right);

        while(!s.isEmpty()){
            right = s.pop();
            left = s.pop();
            int mid= left+(right-left)/2;
            if(left<mid){
                s.push(left);
                s.push(mid);
                s2.push(left);
                s2.push(mid);
            }
            if(mid+1<right){
                s.push(mid+1);
                s.push(right);
                s2.push(mid+1);
                s2.push(right);
            }
        }
        while(!s2.isEmpty()){
            int r= s2.pop();
            int l = s2.pop();
            int mid = l+(r-l)/2;
            merge(nums,l,mid,r,temp);
        }
    }


    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= right) {
                nums[k] = temp[j];
                j++;
                k++;
            }
        }
        if (j > right) {
            while (i <= mid) {
                nums[k] = temp[i];
                i++;
                k++;
            }
        }
    }

}
