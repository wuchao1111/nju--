package main.java.合并数组;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=0;i<N;i++){
            int k = s.nextInt();
            int[][]matrix = new int[k][k];
            for(int a=0;a<k;a++){
                for(int b=0;b<k;b++){
                    matrix[a][b]=s.nextInt();
                }
            }
            print(mergeKArrays(matrix,0,k-1));
            System.out.print("\n");
        }
    }

    //合并matrix的[i,j]行数组；
    public static int[] mergeKArrays(int[][] matrix,int i,int j){
        int k = matrix.length;
        if(i==j)
            return matrix[i];
        if(j-i==1)
            return mergeTwoArray(matrix[i],matrix[j]);
        int mid = (i+j)/2;
        int[] arrays1 = mergeKArrays(matrix, i, mid);
        int[] arrays2 = mergeKArrays(matrix, mid + 1, j);
        return mergeTwoArray(arrays1,arrays2);
    }
    public static int[] mergeTwoArray(int[]a,int[]b){
        int[]res = new int[a.length+b.length];
        int index=0;
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j])
            {
                res[index]=a[i];
                i++;
            }
            else{
                res[index]=b[j];
                j++;
            }
            index++;
        }
        if(i<a.length){
            while(i<a.length){
                res[index]=a[i];
                i++;
                index++;
            }
        }
        if(j<b.length){
            while(j<b.length){
                res[index]=b[j];
                j++;
                index++;
            }
        }
        return res;
    }
    public static void print(int[]array){
        for(int i=0;i<array.length;i++){
            if(i==0)
                System.out.print(array[0]);
            else
                System.out.print(" "+array[i]);
        }
    }
}
