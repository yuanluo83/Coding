package algorithms;

import java.util.HashMap;

public class LRUCache {
	
	public class Entry {
		int key;
		int value;
		Entry newer;
		Entry older;
		public Entry(int key, int value){
			this.key=key;
			this.value=value;
			newer=null;
			older=null;
		}
	}
	
	int capacity;
	
	HashMap<Integer, Entry> registry = null;
	Entry newest;
	Entry oldest;
	
	public LRUCache(int capacity) {
        this.capacity=capacity;
        this.registry = new HashMap<Integer, Entry>();
        newest=null;
        oldest=null;
    }
    
    public int get(int key) {
    	if(!registry.containsKey(key)){
    		return -1;
    	}
    	Entry entry=registry.get(key);
    	int value=entry.value;
    	moveToNewest(entry);
		return value;
    }
    
    public void set(int key, int value) {
    	
    	if(capacity==0){
    		return;
    	}
    	Entry entry=null;
    	if(registry.containsKey(key)){
    		entry=registry.get(key);
    		entry.value=value;
    		moveToNewest(entry);
    		return;
    	}

   		if(registry.size()>=capacity){
    		entry=oldest;
    		int oldestKey=oldest.key;
    		entry.key=key;
    		entry.value=value;
    		moveToNewest(entry);
            registry.remove(oldestKey);
        	registry.put(key, entry);
    	} else if(registry.size()==0){
    	    entry=new Entry(key, value);
        	newest=entry;
        	oldest=entry;
        	registry.put(key, entry);
        } else {
            entry=new Entry(key, value);
            entry.older=newest;
        	newest.newer=entry;
	    	newest=entry;
	    	registry.put(key, entry);
        }

    }
    
    public void moveToNewest(Entry entry){
    	if (entry.newer!=null&&entry.older!=null){
    		entry.newer.older=entry.older;
        	entry.older.newer=entry.newer;
        	entry.older=newest;
        	entry.newer=null;
        	newest.newer=entry;
	    	newest=entry;
    	}else if(entry.newer!=null&&entry.older==null){
    		oldest=entry.newer;
    		entry.newer.older=entry.older;
    		entry.older=newest;
    		entry.newer=null;
        	newest.newer=entry;
	    	newest=entry;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int capacity=2;
		LRUCache cache= new LRUCache(capacity);
		cache.set(2,1);
		cache.set(1,1);
		cache.set(2,3);
		cache.set(4,1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		
		
	}

}
