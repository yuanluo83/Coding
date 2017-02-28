/*
 * 208. Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z. 
 */

package algorithms; 

public class Trie {

	class TrieNode {
        private TrieNode[] links;
        
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[26];
        }
        
        public boolean containsKey(char ch){
            return links[ch - 'a']!=null;
        }
        
        public TrieNode get(char ch){
            return links[ch - 'a'];
        }
        
        public void put(char ch){
            links[ch - 'a'] = new TrieNode();
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
    }
	
	private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!p.containsKey(c)){
                p.put(c);
            }
            p = p.get(c);
        }
        p.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!p.containsKey(c)){
                return false;
            }
            p = p.get(c);
        }
        if (p.isEnd()){
            return true;
        }else {
            return false;
        }

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (!p.containsKey(c)) return false;
            p = p.get(c);
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
