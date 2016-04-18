package algorithms;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Hashtable;
import java.util.Stack;

/*

(add 1 2)
(mult 3 (add 2 3))
(let x 2 (mult x 5)
(let x 2 (mult x (let x 3 y 4 (add x y)))

 * */
public class PrefixCalculator {
	public static boolean isNumeric(String str){
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
	
	public String[] tokenizer(String input){
		String inputNew=input.replace("(", " ( ").replace(")", " ) ").trim();
		return inputNew.split("\\s+");
		
	}
	
	public int Calculator(String input) throws Exception{
		Hashtable<String, Stack<Integer>> context = new Hashtable<String, Stack<Integer>>();
		String[] tokens=this.tokenizer(input);
		return Calculate(tokens, 1, tokens.length-2, context);
	}
	
	public int Calculate(String[] tokens, int begin, int end, Hashtable<String, Stack<Integer>> context) throws Exception{
		if (begin==end){
			return isNumeric(tokens[end])?Integer.parseInt(tokens[end]):(Integer)(((Stack<Integer>)context.get(tokens[end])).pop());
		}else if(end-begin<2){
			throw new Exception("Syntax Error 1.");
		}else if(end-begin==2){
			int left, right;
			switch(tokens[begin]){
				case "let": 
					return Integer.parseInt(tokens[end]);
				case "add": 
					left= isNumeric(tokens[begin+1])?Integer.parseInt(tokens[begin+1]):(Integer)(((Stack<Integer>)context.get(tokens[begin+1])).pop());
					right=isNumeric(tokens[end])?Integer.parseInt(tokens[end]):(Integer)(((Stack<Integer>)context.get(tokens[end])).pop());
					return left+right;
				case "mult":
					left= isNumeric(tokens[begin+1])?Integer.parseInt(tokens[begin+1]):(Integer)(((Stack<Integer>)context.get(tokens[begin+1])).pop());
					right=isNumeric(tokens[end])?Integer.parseInt(tokens[end]):(Integer)(((Stack<Integer>)context.get(tokens[end])).pop());
					return left*right;
				default: throw new Exception("Operator Not Found.");
			}
		}else {
			int index=begin+1;
			int left=0, right=0;
			switch(tokens[begin]){
				case "let": 
					//int index=begin+1;
					while(!tokens[index].equals("(") && !tokens[index].equals(")")){
						//System.out.println("---"+tokens[index]+"="+tokens[index+1]+"---");
						if (context.containsKey(tokens[index])){
							context.get(tokens[index]).push(Integer.parseInt(tokens[index+1]));
						} else{
							Stack<Integer> stack= new Stack<Integer>();
							stack.push(Integer.parseInt(tokens[index+1]));
							context.put(tokens[index], stack);
						}
						index=index+2;
						if(index>end){
							throw new Exception("Syntax Error 2.");
						}
					}
					if(index==end){
						throw new Exception("Syntax Error 3.");
					}
					if(!tokens[index].equals("(")){
						throw new Exception("Syntax Error 4.");
					}
					if(!tokens[end].equals(")")){
						throw new Exception("Syntax Error 5."); 
					}
					return Calculate(tokens, index+1, end-1, context);

				case "add": 
					if(!tokens[index].equals("(")){
						left=Calculate(tokens, index, index, context);
						if(!tokens[index+1].equals("(")){
							right=Calculate(tokens, index+1, index+1, context);
						} else {
							if(!tokens[end].equals(")")){
								throw new Exception("Syntax Error 9."); 
							}
							right=Calculate(tokens, index+2, end-1, context);
						}
					} else{
						int i=index+1;
						while (i<=end){
							//System.out.println("+++"+tokens[i]+"+++");
							if(tokens[i].equals(")")){
								left =  Calculate(tokens, index+1, i-1, context);
							}
							i++;
						}
						if(!tokens[i].equals("(")){
							right=Calculate(tokens, index+1, index+1, context);
						} else {
							if(!tokens[end].equals(")")){
								throw new Exception("Syntax Error 9."); 
							}
							right=Calculate(tokens, i+1, end-1, context);
						}
						
					}
					return left+right;
				case "mult": 
					if(!tokens[index].equals("(")){
						left=Calculate(tokens, index, index, context);
						if(!tokens[index+1].equals("(")){
							right=Calculate(tokens, index+1, index+1, context);
						} else {
							if(!tokens[end].equals(")")){
								throw new Exception("Syntax Error 9."); 
							}
							right=Calculate(tokens, index+2, end-1, context);

						}
					} else{
						int i=index+1;
						while (i<=end){
							//System.out.println("+++"+tokens[i]+"+++");
							if(tokens[i].equals(")")){
								left =  Calculate(tokens, index+1, i-1, context);
							}
							i++;
						}
						if(!tokens[i].equals("(")){
							right=Calculate(tokens, index+1, index+1, context);
						} else {
							if(!tokens[end].equals(")")){
								throw new Exception("Syntax Error 9."); 
							}
							right=Calculate(tokens, i+1, end-1, context);

						}
						
					}
					return left*right;
				default: throw new Exception("Operator Not Found.");
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input=new String[10];
		input[0]="(add 1 2)";
		input[1]="(mult 3 (add 2 3))";
		input[2]="(let x 2 (mult x 5))";
		input[3]="(let x 2 (mult x (let x 3 y 4 (add x y))))";
		input[4]="(let x 2 y 5 (mult x(let x 3 y 4 (add x y))))";
		input[5]="(10)";
		input[6]="(let x 4)";
		PrefixCalculator pCal=new PrefixCalculator();
		
		for (String token : pCal.tokenizer(input[2])){
			//System.out.println(token);
		}
		try {
			for (int i=0; i<=6; i++){
				System.out.println(pCal.Calculator(input[i]));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
