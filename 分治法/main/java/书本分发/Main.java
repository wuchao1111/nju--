package 书本分发;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int pages[] = new int[n];
            for (int j = 0; j < n; j++) {
                pages[j] = sc.nextInt();
            }
            int m = sc.nextInt();

            if (n < m) {//有人分不到一本
                System.out.println(-1);
                continue;
            }
            System.out.println(makeBuckets(pages, m));

        }
    }

    static int getBuckets(int pages[], int buckets_max) {
        int total = 0;
        int buckets = 1;//按当前桶的大小可以分几桶
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (total > buckets_max) {//大于桶的最大值说明桶容量应该更大
                total = pages[i];
                buckets++;
            }
        }
        return buckets;
    }

    static int makeBuckets(int pages[], int m) {
        int max = Integer.MIN_VALUE;//以数组中的最大元素作为最小的桶容量
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            max = Math.max(max, pages[i]);
            sum += pages[i];
        }
        int low = max;
        int high = sum;
        //二分查找桶容量
        while (low < high) {
            int mid = (low + high) / 2;
            if (getBuckets(pages, mid) > m) {//桶太小
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

