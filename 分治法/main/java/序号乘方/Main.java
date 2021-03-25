package 序号乘方;

import java.util.ArrayList;
import java.util.Scanner;

/**Description
 * There are Infinite People Standing in a row, indexed from 1.A person having index 'i' has strength of (i*i).You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.
 *
 * Input
 * First line contains an integer 'T' - the number of testcases,Each of the next 'T' lines contains an integer 'P'- Your Power.Constraints:1<=T<=100001<=P<=1000000000000000
 *
 * Output
 * For each testcase Output The maximum Number of People You can kill.
 **/    
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i =0;i<T;i++){
            Long x = s.nextLong();
            System.out.println(getKill(x));
        }
    }

    public static int getKill(Long x){
        int res=0;
        Long killed=1l;
        while(true){
            x-=killed*killed;
            if(x<0)
                break;
            killed++;
            res++;
        }
        return res;
    }
}
