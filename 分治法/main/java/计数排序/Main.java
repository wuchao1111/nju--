package 计数排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述:Description
 * 实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。
 * <p>
 * <p>
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 * <p>
 * <p>
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.nextInt();
        }
        countSort(num);
        for (int j = 0; j < num.length; j++) {
            if (j == 0)
                System.out.print(num[j]);
            else
                System.out.print(" " + num[j]);
        }
    }

    public static void countSort(int[] n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n.length; i++) {
            max = Math.max(n[i], max);
            min = Math.min(n[i], min);
        }
        int[] count = new int[max - min + 1];
        for (int j = 0; j < n.length; j++) {
            count[n[j] - min]++;
        }
        int index = 0;
        for (int k = 0; k < count.length; k++) {
            while (count[k] > 0) {
                n[index++] = k + min;
                count[k]--;
            }
        }
    }
}
