package main.java.二叉树;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0;i<T;i++){
            int[] tree = new int[s.nextInt()];
            for(int j=0;j<tree.length;j++)
                tree[j]=s.nextInt();
            printTree(tree);
        }
    }

    private static void printTree(int[] tree) {
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer>res = new ArrayList<>();
            for(int i=0;i<len;i++){
                int index = q.poll();
                res.add(tree[index]);
                if(index*2+1<tree.length)
                    q.add(index*2+1);
                if(index*2+2<tree.length)
                    q.add(index*2+2);
            }
            res.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                        if(o1.equals(0)&&o2.equals(Integer.MIN_VALUE))
                            return 1;
                        else if(o1.equals(Integer.MAX_VALUE))
                            return 1;
                        else if(o1.equals(Integer.MIN_VALUE))
                            return -1;
                        else
                            return o1-o2;

                }
            });
            for(int i=0;i<res.size();i++)
            {
                if(i==0)
                    System.out.print(res.get(i));
                else{
                    if(!res.get(i).equals(res.get(i-1)))
                        System.out.print(" "+res.get(i));
                }
            }
            System.out.print("\n");
        }
    }
}
