package 数组查询;

import java.util.Scanner;

/**
 * Description
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you may remove at most one element to get the maximum sum.
 * <p>
 * <p>
 * Input
 * 第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。
 * <p>
 * <p>
 * Output
 * 每一行表示对应用例的结果。
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++)
                a[j] = s.nextInt();
            System.out.println(getMax(a));
        }
    }

    public static int getMax(int[] a) {
        if(a.length==0)
            return 0;
        int[]preMax = new int[a.length];
        for(int i=1;i<a.length;i++){
            preMax[i]=preMax[i-1]+a[i-1];
        }
        int max=Integer.MIN_VALUE;
        int temp=0;
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1)
                temp=0;
            else
                temp+=a[i+1];
            max=Math.max(preMax[i]+temp,max);
        }
        return max;

    }
}
