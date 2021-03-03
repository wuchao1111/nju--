package 数学公式;

import java.util.Scanner;

/**
* Description
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 *
 *
 * Input
 * The first line of input consists number of the test cases. The following T lines consist of 3 numbers each separated by a space and in the following order:A B C'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5
 *
 *
 * Output
 * In each separate line print the modular exponent of the given numbers in the test case.
* */

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for(int i=0;i<count;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            System.out.println(getPow(a,b,c));
        }
    }
    public static int getPow(int a,int b,int c){
        int res=1;
        for(int i=1;i<=b;i++){
            res*=a;
            if(res>=c)
                res=res%c;
        }
        return res;
    }
}
