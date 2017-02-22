package algorithms;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {

	public class Vector2D {

		private Iterator<List<Integer>> i;
	    private Iterator<Integer> j;

	    public Vector2D(List<List<Integer>> vec2d) {
	        i = vec2d.iterator();
	    }

	    public int next() {
	        hasNext();
	        return j.next();
	    }

	    public boolean hasNext() {
	        while ((j == null || !j.hasNext()) && i.hasNext())
	            j = i.next().iterator();
	        return j != null && j.hasNext();
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
