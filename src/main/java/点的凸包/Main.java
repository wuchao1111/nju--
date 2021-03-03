package main.java.点的凸包;

import java.util.*;

public class Main {
    public static class Point {
        private int x;
        private int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return y;
        }
    }

    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY, int targetX, int targetY) {
//        throw new RuntimeException("implement me!");
        double angle;
        int x = targetX - currentX;
        int y = targetY - currentY;
        angle = Math.atan2(x, y)*180.0/Math.PI-currentBearing;
        return angle < 0? angle + 360 : angle;
    }

    public static double calculateBearingToPoint(double currentBearing, double currentX, double currentY,double targetX, double targetY) {
        //throw new RuntimeException("implement me!");
        double angle;
        double x = targetX - currentX;
        double y = targetY - currentY;
        angle = Math.atan2(x, y)*180.0/Math.PI-currentBearing;
        return angle < 0? angle + 360 : angle;
    }

    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and
     * there are other algorithms too.
     *
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static List<Point> convexHull(List<Point> points) {
//        throw new RuntimeException("implement me!");
        List<Point> shellPoint = new ArrayList<>();
        Point minPoint = null;
        double nowBearing;
        double nextBearing;
        double preBearing;
        double nextLength;
        Point nowPoint;
        Point nextPoint = null;
//    	Iterator<Point> it = points.iterator();
        if(!points.isEmpty())
        {
            //元素小于3个时，必是凸包直接返回
            if(points.size() <=3)
                return points;

            //求最左下元素
            for(Point point : points)
            {
                if(minPoint == null){
                    minPoint = point;
                    continue;
                }
                if(minPoint.getX() > point.getX())
                    minPoint = point;
                else if(minPoint.getX() == point.getX())
                {
                    if(point.getY() < minPoint.getY())
                        minPoint = point;
                }
            }

            shellPoint.add(minPoint); //最左下元素定时凸包元素，加入集合
            nowPoint = minPoint;
            preBearing = 0; //之前凸包元素指向最近凸包元素的角度（相对与y轴顺时针）
            while(true)
            {
                nextBearing = 360;
                nextLength = Double.MAX_VALUE;
                for(Point point : points)
                {
                    if(point.equals(nowPoint))
                        continue;
                    nowBearing = calculateBearingToPoint(preBearing,(int)nowPoint.getX(),(int)nowPoint.getY(),(int)point.getX(),(int)point.getY());
                    if(nextBearing == nowBearing){
                        if(nextLength < (Math.pow(point.getX()-nowPoint.getX(), 2)+Math.pow(point.getY()-nowPoint.getY(), 2)))
                        {
                            nextLength = Math.pow(point.getX()-nowPoint.getX(), 2)+Math.pow(point.getY()-nowPoint.getY(), 2);
                            nextPoint = point;
                        }
                    }
                    else if(nextBearing > nowBearing) {
                        nextLength = Math.pow(point.getX()-nowPoint.getX(), 2)+Math.pow(point.getY()-nowPoint.getY(), 2);
                        nextBearing = nowBearing;
                        nextPoint = point;
                    }
                }
                if(minPoint.equals(nextPoint))
                {
                    break;
                }
                nowPoint = nextPoint;
                preBearing += nextBearing;
                shellPoint.add(nextPoint);
            }

        }
        return shellPoint;
    }




    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            List<Point> points = new ArrayList<>();
            for(int j=0;j<n;j++){
                int x = s.nextInt();
                int y = s.nextInt();
                points.add(new Point(x,y));
            }
            List<Point> convexPoint = convexHull(points);
            if(convexPoint.size()==0)
                System.out.println(-1);
            convexPoint.sort(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.getX()-o2.getX();
                }
            });
            System.out.print(convexPoint.get(0).getX()+" "+convexPoint.get(0).getY());
            for(int k=1;k<convexPoint.size();k++){
                System.out.print(", "+convexPoint.get(k).getX()+" "+convexPoint.get(k).getY());
            }
            System.out.print("\n");
        }
    }
}
