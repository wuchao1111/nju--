package 最小交换次数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 * <p>
 * <p>
 * Input
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .(1<=T<=100;1<=N<=100;1<=A[] <=1000)
 * <p>
 * <p>
 * Output
 * For each test case in a new line output will be an integer denoting minimum umber of swaps that are required to sort the array.
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int len = s.nextInt();
            int[] number = new int[len];
            for (int j = 0; j < len; j++)
                number[j] = s.nextInt();
            System.out.println(selectSort(number));
        }
    }

    public static int selectSort(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            int min = i;
            for (int j = i; j < number.length; j++) {
                if (number[j] < number[min])
                    min = j;
            }
            if (min == i)
                continue;
            else {
                int temp = number[min];
                number[min] = number[i];
                number[i] = temp;
                count++;
            }
        }
        return count;
    }
}
