package main.java.和为定值的子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int[] n = new int[s.nextInt()];
            int sum = s.nextInt();
            for (int j = 0; j < n.length; j++) {
                n[j] = s.nextInt();
            }
            Arrays.sort(n);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(n, 0, sum, res, temp);
            for(List<Integer> ans:res){
                for(int x:ans){
                    System.out.print(x+" ");
                }
                System.out.print("$");
            }
            System.out.print("\n");
        }
    }

    public static void dfs(int[] n, int x, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size()>4)
            return;
        if (sum == 0&&temp.size()==4)
            res.add(new ArrayList<>(temp));
        for (int i = x; i < n.length; i++) {
            if (i != x && n[i] == n[i - 1]) {
                continue;
            }
            temp.add(n[i]);
            sum -= n[i];
            dfs(n, i + 1, sum, res, temp);
            sum += n[i];
            //如果不加回来的话下一次循环时sum的值就是错误的
            temp.remove(temp.size() - 1);
        }
    }
}
