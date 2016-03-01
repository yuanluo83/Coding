package com.leetcode.oj;

import java.util.List;

public class Flatten2DVector {

	public class Vector2D {

		int p1 = 0;
		int p2 = 0;
		int size1 = 0;
		List<List<Integer>> vec2d;
	    public Vector2D(List<List<Integer>> vec2d) {
	    	vec2d= vec2d;
	        size1 = vec2d.size();
	    }

	    public int next() {
	        return 0;
	    }

	    public boolean hasNext() {
	    	if (p1<=size1){
	    		if(p2<=vec2d.get(p1).size()){
	    			return true;
	    		}
	    	}
	        return false;
	    }
	}

	/**
	 * Your Vector2D object will be instantiated and called as such:
	 * Vector2D i = new Vector2D(vec2d);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
