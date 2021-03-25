package 倒置个数;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description
 * 有一个由N个实数构成的数组，如果一对元素A[i]和A[j]是倒序的，即i<j但是A[i]>A[j]则称它们是一个倒置，设计一个计算该数组中所有倒置数量的算法。要求算法复杂度为O(nlogn)
 * <p>
 * Input
 * 输入有多行，第一行整数T表示为测试用例个数，后面是T个测试用例，每一个用例包括两行，第一行的一个整数是元素个数，第二行为用空格隔开的数组值。
 * <p>
 * Output
 * 输出每一个用例的倒置个数，一行表示一个用例。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int number = s.nextInt();
            int[] nums = new int[number];
            int[] temp = new int[number];
            for (int j = 0; j < number; j++)
                nums[j] = s.nextInt();
        }
    }


    public static int reversPairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversPairs(nums, left, mid, temp);
        int rightPairs = reversPairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1])
            return leftPairs + rightPairs;
        int mergePairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + mergePairs;
    }

    public static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        int count = 0;
        int k = left;//合并数组当前的索引
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                count += j - mid - 1;
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }
        if (j == right + 1) {
            while (i <= mid) {
                nums[k] = temp[i];
                i++;
                k++;
                count += j - mid - 1;
            }
        }
        return count;
    }
}
