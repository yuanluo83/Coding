package com.leetcode.oj.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.algorithms.BinaryTreeRightSideView.StackObject;
import com.leetcode.oj.algorithms.BinaryTreeRightSideView.TreeNode;

public class WordSearchII {
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> list= new ArrayList<String>();
	    TrieNode trie= BuildTrie(words);
	    for (int x=0;x<board.length;x++){
			for (int y=0;y<board[0].length;y++){
				dfs(board, x, y, trie, list);
			}
		}
        return list;
    }
	
	public void dfs(char[][] board, int x, int y, TrieNode trie, List list) {
		String word = null;
		char c = board[x][y];
		if (c=='#'||trie.next[c-'a']==null){
			return;
		}
		trie = trie.next[c-'a'];
		if (trie.val !=null){
			list.add(trie.val);
			trie.val=null; //remove word from trie when found.
		}
		board[x][y]='#'; //in the dfs, mark visited cell as '#'
		if (x>0) dfs(board, x-1, y, trie, list);
		if (x<board.length-1) dfs(board, x+1, y, trie, list);
		if (y>0) dfs(board, x, y-1, trie, list);
		if (y<board[0].length-1) dfs(board, x, y+1, trie, list);
		board[x][y]=c; // unmark visited cell, before select the next neighbor cell.

    }
	
	class TrieNode {
		String val=null;
		TrieNode[] next=new TrieNode[26];
	}
	
	public TrieNode BuildTrie(String words[]){
		TrieNode root= new TrieNode();
		
		for (String word : words){
			TrieNode p = root;
			for (char c : word.toCharArray()){
				int index = c - 'a';
				//System.out.println(index);
				if (p.next[index]==null){
					p.next[index]= new TrieNode();
				}	
				p = p.next[index];			
			}
			p.val= word;
		}
		return root;
	}
	
  
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	char[][] board = new char[][]{
    		{'o','a','a','n'},
    		{'e','t','a','e'},
    		{'i','h','k','r'},
    		{'i','f','l','v'}
    	};
    	
    	String words1[] = new String[]{"oath","pea","eat","rain"};
    	String words2[] = new String[]{"b","a","b","b","a"};
    	String words3[] = new String[]{"baa","abba","baab","aba"};
    	List ls = new WordSearchII().findWords(board, words3);
    	Iterator it = ls.iterator();
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
	}
    
    
}
