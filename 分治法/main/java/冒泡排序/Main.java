package 冒泡排序;

import java.util.Scanner;

/**
 * Description
 * 实现冒泡排序。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
* */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number  = new int[scanner.nextInt()];
        int x=0;
        while(scanner.hasNextInt())
        {
            number[x]=scanner.nextInt();
            x++;
        }
        sort(number);
        for (int i=0;i<number.length;i++)
        {
            if(i==0)
                System.out.print(number[i]);
            else
                System.out.print(" "+number[i]);
        }
    }

    public static void sort(int[] number){
        for(int i=0;i<number.length;i++){
            for(int j=0;j<number.length-i;j++){
                if(j!=number.length-i-1&&number[j]>number[j+1])
                {
                    int temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
    }


}
