package main.java.实现Shell排序;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        long a=System.currentTimeMillis();
        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++){
            String[] s2 = s.nextLine().split(" ");
            String[] s3 = s.nextLine().split(" ");
            int[] num = new int[s2.length];
            for(int j=0;j<num.length;j++)
            {
                num[j]=Integer.valueOf(s2[j]);
            }
            for(int k=0;k<s3.length;k++){
                shellSort(num,Integer.parseInt(s3[k]));
            }
            print(num);

            System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        }
    }

    //对步长为step的子数组进行插入排序
    public static void shellSort(int[] arr,int step){
        for (int i = step; i < arr.length; i++) {
            int value = arr[i];
            int j;
            //对步长区间中具体的元素进行比较
            for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                //j为左区间的取值，j+step为右区间与左区间的对应值。
                arr[j + step] = arr[j];
            }
            //此时step为一个负数，[j + step]为左区间上的初始交换值
            arr[j + step] = value;
        }
    }
    public static void swap(int[]num,int a,int b){
        int temp = num[a];
        num[a]=num[b];
        num[b]=temp;
    }
    public static void print(int[]num){
        for(int i=0;i<num.length;i++){
            if(i==0)
                System.out.print(num[i]);
            else
                System.out.print(" "+num[i]);
        }
        System.out.print("\n");
    }
}