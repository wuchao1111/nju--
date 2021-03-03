package main.java.堆排序;

import java.util.Scanner;
import java.util.Stack;

/**
 * 类名:Main
 * 描述:TODO
 * 姓名:舒克
 * 日期:2021-01-19 16:25
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();
        heapSort(nums, nums.length - 1);
        for (int i = 0; i < n; i++) {
            if (i == 0)
                System.out.print(nums[i]);
            else
                System.out.print(" " + nums[i]);
        }
    }

    private static void heapSort(int[] nums, int end) {
        //将待排序列变成一个大顶堆
        adjustHeap(nums,end);
        //从最后一个节点开始，每一个节点与堆顶交换，然后调整堆。
        for(int i=end;i>0;i--){
            swap(nums,0,i);
            adjust(nums,0,i-1);
        }
    }

    public static void adjustHeap(int[]nums,int end){
        for(int i=(end-1)/2;i>=0;i--){
            adjust(nums,i,end);
        }
    }

    public static void adjust(int[] nums,int i,int end){
        int large=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<=end&&nums[left]>nums[large])
            large=left;
        if(right<=end&&nums[right]>nums[large])
            large=right;
        if(large!=i){
            swap(nums,large,i);
            adjust(nums,large,end);
        }
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}

