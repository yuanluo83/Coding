package com.leetcode.oj;

import java.util.HashMap;

public class MaxPointsonaLine {

	//Definition for a point.
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
public int maxPoints(Point[] points) {
        
        if(points.length<3){
            return points.length;
        }
		
		double slope=0;
		int maxPoints=0;
		for(int i=0;i<points.length;i++){
			int SamePoint=0;
			int tmpMaxPoints=1;
			HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
			for(int j=i+1;j<points.length;j++){
				if(points[i].x==points[j].x&&points[i].y==points[j].y){
					SamePoint++;
				}else{
					slope=slope(points[i],points[j]);
					//System.out.println(slope);
					if(hm.containsKey(Double.valueOf(slope))){
						hm.put(Double.valueOf(slope), hm.get(Double.valueOf(slope))+1);
					}else{
						hm.putIfAbsent(Double.valueOf(slope), 2);
					}
				}
			}
			for(Double key: hm.keySet()){
				tmpMaxPoints=(tmpMaxPoints>hm.get(key)?tmpMaxPoints:hm.get(key));
			}
			tmpMaxPoints=tmpMaxPoints+SamePoint;
			maxPoints=(maxPoints>tmpMaxPoints?maxPoints:tmpMaxPoints);
		}
		
		return maxPoints;
    }
	
	public double slope(Point pt1, Point pt2){
		if(pt1.x==pt2.x){
			return Integer.MAX_VALUE;
		}else if(pt1.y==pt2.y){
			return (double)0;
		}
		else{
			return (double)((double)(pt1.y-pt2.y))/((double)(pt1.x-pt2.x));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] intPoints={{29,87},{145,227},{400,84},{800,179},{60,950},{560,122},{-6,5},{-87,-53},{-64,-118},{-204,-388},{720,160},{-232,-228},{-72,-135},{-102,-163},{-68,-88},{-116,-95},{-34,-13},{170,437},{40,103},{0,-38},{-10,-7},{-36,-114},{238,587},{-340,-140},{-7,2},{36,586},{60,950},{-42,-597},{-4,-6},{0,18},{36,586},{18,0},{-720,-182},{240,46},{5,-6},{261,367},{-203,-193},{240,46},{400,84},{72,114},{0,62},{-42,-597},{-170,-76},{-174,-158},{68,212},{-480,-125},{5,-6},{0,-38},{174,262},{34,137},{-232,-187},{-232,-228},{232,332},{-64,-118},{-240,-68},{272,662},{-40,-67},{203,158},{-203,-164},{272,662},{56,137},{4,-1},{-18,-233},{240,46},{-3,2},{640,141},{-480,-125},{-29,17},{-64,-118},{800,179},{-56,-101},{36,586},{-64,-118},{-87,-53},{-29,17},{320,65},{7,5},{40,103},{136,362},{-320,-87},{-5,5},{-340,-688},{-232,-228},{9,1},{-27,-95},{7,-5},{58,122},{48,120},{8,35},{-272,-538},{34,137},{-800,-201},{-68,-88},{29,87},{160,27},{72,171},{261,367},{-56,-101},{-9,-2},{0,52},{-6,-7},{170,437},{-261,-210},{-48,-84},{-63,-171},{-24,-33},{-68,-88},{-204,-388},{40,103},{34,137},{-204,-388},{-400,-106}};
		//int[][] intPoints={{1,1},{1,1},{1,1}};
		MaxPointsonaLine mxp = new MaxPointsonaLine();
		Point[] points = new Point[intPoints.length];
		for(int i=0;i<intPoints.length;i++){
			points[i]=mxp.new Point(intPoints[i][0],intPoints[i][1]);
		}
		System.out.println(mxp.maxPoints(points));
	}

}
