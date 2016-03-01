package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList[] courses = new ArrayList[numCourses];
		ArrayList<Integer> order = new ArrayList<Integer>();
		int[] status = new int[numCourses];
		for(int i = 0; i < numCourses; i++){
			status[i]=0;
			courses[i]=new ArrayList<Integer>();
		}
		for(int[] edge : prerequisites){
			courses[edge[0]].add(edge[1]);
		}
		
		for(int courseID = 0; courseID < numCourses; courseID++){
			if (dfs(courses, courseID, status, order)==false){
				return new int[0];
			}
		}
		int[] answer = new int[numCourses];
		for(int i=0;i<order.size();i++)
			answer[i]=order.get(i);
		return answer;
    }
	
	public boolean dfs(ArrayList[] courses, int courseID, int[] status, ArrayList<Integer> order){

		if (status[courseID]==1){
			return false;
		} else if (status[courseID]==2){
			return true;			
		} else {
			status[courseID] = 1;
			for (int i = 0; i < courses[courseID].size(); i++){
				if (dfs(courses, (int)courses[courseID].get(i), status, order)==false){
					return false;
				}
			}
		}
		order.add(courseID);
		status[courseID] = 2;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
