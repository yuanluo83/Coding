package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AlienDictionary {

	public String alienOrder(String[] words) {
		ArrayList<Character> order=new ArrayList<Character>();
        HashMap<Character, HashSet<Character>> graph = buildGraph(words);
        Set<Character> nodes = graph.keySet();
        Iterator<Character> it = nodes.iterator();
        HashMap<Character,Integer> status = new HashMap<Character,Integer>();
        while (it.hasNext()){
        	status.put(it.next(), 0);
        }
        it = nodes.iterator();
        while (it.hasNext()){
        	if(dfs( graph, it.next(), status, order)==false)
        	    return "";
        	
        }
        String answer = "";
		for(int i=order.size()-1; i>=0;i--)
			answer=answer+order.get(i);
		if (answer ==""){
		    return words[0];
		}
		return answer;
    }
	
	public boolean dfs(HashMap graph, char c, HashMap status, ArrayList<Character> order){
		if(!status.containsKey(c)){
			status.put(c, 0);
		};
		if ((int)status.get(c)==1){
			return false;
		} else if ((int)status.get(c)==2){
			return true;			
		} else if (graph.containsKey(c)){
			status.put(c,1);
			HashSet set = (HashSet)graph.get(c);
			Iterator it = set.iterator();
			while (it.hasNext()){
				if (dfs(graph, (char)it.next(), status, order)==false){
					return false;
				}
			}
		}
		order.add(c);
		status.put(c,2);
		return true;
	}
	
	public HashMap buildGraph(String[] words){
		HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
		int charAt = 0;
		int start = 0;
		int end = words.length-1;
		buildMap(words, start, end, charAt, map);
		return map;
	}
	
	public void buildMap(String[] words, int start, int end, int charAt, HashMap<Character, HashSet<Character>> map){
		//System.out.println(start+" "+end+" "+charAt);
		while (start<=end&&words[start].length()<=charAt){
			start++;
		}
		if (start>end) {
			return;
		}
		int start_c = start;
		int end_c = end;
		char prev_c = words[start].charAt(charAt);
		int processed=-1;
		for (int i = start_c; i <= end_c; i++){
			if (words[i].length()>charAt){
				char c = words[i].charAt(charAt);
				//System.out.println(" -- "+ prev_c +" - > " +c);
				if (c != prev_c){
					end = (i-1>0?i-1:0);
					if (map.containsKey(prev_c)){
						map.get(prev_c).add(c);
					} else {
						HashSet set = new HashSet<Character>();
						set.add(c);
						map.put(prev_c, set);
					}
					processed=end;
					buildMap(words, start, end, charAt+1, map);
					prev_c=c;
					start = i;
					end = i;
					
				} else {
					end = i;
				}
			}
		}
		if (processed==-1||processed!=end){
				char c = words[end].charAt(charAt);
				if (!map.containsKey(c)){
					HashSet set = new HashSet<Character>();
					map.put(c, set);
				}
				//System.out.println(" -- "+ c +" - > " );
				
				buildMap(words, start, end, charAt+1, map);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {	"wrt",
							"wrf",
							"er",
							"ett",
				  			"rftt"};
		String[] words2 = {"ab","adc"};
		HashMap graph = new AlienDictionary().buildGraph(words2);
		Set nodes = graph.keySet();
        Iterator<Character> it = nodes.iterator();
        HashMap<Character,Integer> status = new HashMap<Character,Integer>();
        while (it.hasNext()){
        	char c = it.next();
        	Set nds = (HashSet)graph.get(c);
        	Iterator<Character> iter = nds.iterator();
        	while (iter.hasNext()){
        		System.out.println(c +" - > " +iter.next());
        	}
        }
        
        System.out.println(new AlienDictionary().alienOrder(words2));
		
	}

}
