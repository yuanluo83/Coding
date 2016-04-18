package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list= new ArrayList<String>();
		int size = words.length;
		int start = 0;
		int width=0;
		for (int end=0; end<size; end++){
			if(width==0&&words[start].length()<=maxWidth){
				width=words[start].length();
			} 
			int peep=end+1;
			if(peep==size) {
				list.add(justifyLine(words, start, end, maxWidth-width));
	    		break;
			}  else if (width+words[peep].length()+1<=maxWidth){
	    		width=width+words[peep].length()+1;
	    	} else {
	    		list.add(justifyLine(words, start, end, maxWidth-width));
	    		width=0;
	    		start=peep;
	    	}
	    	
	    }
		return list;
    }
	
	public String justifyLine (String[] words, int start, int end, int space){
		String str="";
		int slot = end - start;
		
		
		if(slot==0){
			str=words[start]+spaceGen(space);
		}else if (end==words.length-1){
			str= words[start];
			for (int i=start+1;i<=end;i++){
				str=str+" "+words[i];
			}
			str=str+spaceGen(space);
		} else {
			int num_less = space/slot;
			int delta = space - num_less*slot;
			int num_more = num_less + (delta==0?0:1);
			int count_more = delta;
			str= words[start];
			for (int i=start+1;i<=end;i++){
				if(count_more>0){
					str=str+" "+spaceGen(num_more)+words[i];
					count_more--;
				} else {
					str=str+" "+spaceGen(num_less)+words[i];
				}
			}
		}
		return str;
	}
	
	public String spaceGen(int space){
		return new String(new char[space]).replace('\0', ' ');
	}

    
    public static void main(String[] args) {
    	
    	String words[] = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    	String words2[] = new String[]{"What","must","be","shall","be."};
    	int L = 15;
    	List ls = new TextJustification().fullJustify(words, L);
    	Iterator it = ls.iterator();
    	while (it.hasNext()){
    		System.out.println(it.next()+"#");
    	}
	}
    
    
}
