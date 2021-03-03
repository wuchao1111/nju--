package 插入排序;

import java.util.Scanner;

/**
 Description
 实现插入排序。

 Input
 输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。

 Output
 输出排序的数组，用空格隔开，末尾不要空格。
 * */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            int count = s.nextInt();
            int[] number = new int[count];
            for(int j=0;j<count;j++)
                number[j]=s.nextInt();
            SortAndPrint(number);
        }
    }

    public static void SortAndPrint(int[] number){
        for(int i=0;i<number.length;i++){
            int key = number[i];
            int j =0;
            while(number[j]<key){
                j++;
            }
            for(int k=i;k>j;k--)
                number[k]=number[k-1];
            number[j]=key;
        }
        for(int i=0;i<number.length;i++){
            if(i==0)
                System.out.print(number[i]);
            else
                System.out.print(" "+number[i]);
        }
        System.out.print("\n");
    }
}
