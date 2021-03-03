package main.java.分治法解最近对问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n= Integer.parseInt(s.nextLine());
        for(int i=0;i<n;i++){
            String nextLine = s.nextLine();
            String[] point = nextLine.split(",");
            Arrays.sort(point, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    String[] s1 = a.split(" ");
                    double aX=Double.parseDouble(s1[0]);
                    double aY=Double.parseDouble(s1[1]);
                    String[] s2 = b.split(" ");
                    double bX=Double.parseDouble(s2[0]);
                    double bY=Double.parseDouble(s2[1]);
                    if(aX>bX)
                        return 1;
                    else if(aX<bX)
                        return -1;
                    else{
                        if(aY>bY)
                            return 1;
                        else if(aY<bY)
                                return -1;
                        else return 0;
                    }
                }
            });
            System.out.println(getMin(point).toString());
        }
    }

    public static double getDistance(String a,String b){
        String[] s1 = a.split(" ");
        double aX=Double.parseDouble(s1[0]);
        double aY=Double.parseDouble(s1[1]);
        String[] s2 = b.split(" ");
        double bX=Double.parseDouble(s2[0]);
        double bY=Double.parseDouble(s2[1]);
        return Math.pow(aX-bX,2)+Math.pow(aY-bY,2);
    }

    public static StringBuilder getMin(String[] point){
        double min=Double.MAX_VALUE;
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<point.length;i++){
            for(int j=i+1;j< point.length;j++)
            {
                double temp = getDistance(point[i],point[j]);
                if(temp<min) {
                    res=new StringBuilder("");
                    res.append(point[i]);
                    res.append(",");
                    res.append(point[j]);
                    res.append(",");
                    min=temp;
                }
                else if(getDistance(point[i],point[j])==min){
                    res.append(point[i]);
                    res.append(",");
                    res.append(point[j]);
                    res.append(",");
                }
                else
                    continue;;
            }
        }
        res.deleteCharAt(res.length()-1);
        return res;
    }


}
