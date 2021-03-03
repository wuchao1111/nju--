package main.java.宠物屋涂色;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int number = s.nextInt();
            int[] board = new int[s.nextInt()];
            for (int j = 0; j < board.length; j++)
                board[j] = s.nextInt();
            System.out.println(makeBuckets(board, number));
        }
    }

    public static int getBuckets(int[] board, int Volume) {
        int n = 1;
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[i];
            if (sum > Volume) {
                n++;
                sum = board[i];
            }
        }
        return n;
    }

    public static int makeBuckets(int[] board, int k) {
        int max = 0;
        int min=Integer.MIN_VALUE;
        for (int i = 0; i < board.length; i++) {
            max += board[i];
            min=Math.max(min,board[i]);
        }
        while(min<max){
            int mid = (min+max)/2;
            int buckets = getBuckets(board, mid);
            if(buckets>k){
                min=mid+1;
            }//桶太多，容量太小了
            else if(buckets<k){
                max=mid-1;
            }//桶不够，容量太大了
            else{
                max=mid;
            }//桶正好，但是容量也可能过大
        }
        return min;
    }
}
