package main.java.按照数值个数排序;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i = 1; i <= num; i++) {
            int n = s.nextInt();
            int[] nums = new int[n];
            Map<Integer,Integer> m =new HashMap<>();
            for (int j = 0; j < n; j++) {
                nums[j]=s.nextInt();
                m.put(nums[j],m.getOrDefault(nums[j],0)+1);
            }
            sort(nums,m);
            print(nums);
        }
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

    public static void sort(int[] number,Map<Integer,Integer>m){
        for(int i=0;i<number.length;i++){
            for(int j=0;j<number.length-i;j++){
                if(j!=number.length-i-1&&m.get(number[j])<m.get(number[j+1]))
                {
                    int temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
    }

}