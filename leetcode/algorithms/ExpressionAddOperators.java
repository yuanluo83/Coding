/*
 * 282. Expression Add Operators
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits 
 * so they evaluate to the target value.
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */

package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num==null || num.length()==0) {
            return result;
        }
        String curExpression = "";
        int curValue = Character.getNumericValue(num.charAt(0));
        int curPriorityValue = curValue;
        dfs(result, num, target, 1, num.substring(0, 1), curValue, curPriorityValue, -1);
        return result;
    }
    /*
     * Depth First Search:
     * curExpression: current expression, eg. "1+4*8" 
     * curValue: current value, eg. 33 for the above expression.  
     * curPriorityValue: the current priority value, eg. 32 for "1+4*8", 64 for "1+4*8*2", and 4 for "1+4"
     * lastOperatorIndex: the last operator index value, eg. 3 for "1+4*8", 5 for "1+4*8*2", and 1 for "1+4"
     */
    public void dfs(List<String> result, String num, int target, int index, String curExpression, int curValue, int curPriorityValue, int lastOperatorIndex) {
        if (index==num.length()) {
            if (curValue == target) result.add(curExpression);
            return;
        }else {
            int lastNumber = Integer.valueOf(curExpression.substring(lastOperatorIndex+1));
            if (lastNumber!=0){
                int newLastNumber = lastNumber * 10 + Character.getNumericValue(num.charAt(index));
                if ((lastNumber>0&&newLastNumber>0) || (lastNumber<0&&newLastNumber<0)){
                    int curPriorityValue0 = (curPriorityValue/lastNumber)*newLastNumber;
                    int curValue0 = curValue - curPriorityValue + curPriorityValue0;
                    dfs(result, num, target, index+1, curExpression+num.substring(index, index+1), curValue0, curPriorityValue0,lastOperatorIndex);
                }
            }
        
            int curPriorityValue1 = Character.getNumericValue(num.charAt(index));
            int curValue1 = curValue + curPriorityValue1;
            dfs(result, num, target, index+1, curExpression+"+"+num.substring(index, index+1), curValue1, curPriorityValue1, curExpression.length());
        
            int curPriorityValue2 = 0 - Character.getNumericValue(num.charAt(index));
            int curValue2 = curValue + curPriorityValue2;
            dfs(result, num, target, index+1, curExpression+"-"+num.substring(index, index+1), curValue2, curPriorityValue2, curExpression.length());
        
            int curPriorityValue3 = curPriorityValue * Character.getNumericValue(num.charAt(index));
            int curValue3 = curValue - curPriorityValue + curPriorityValue3;
            dfs(result, num, target, index+1, curExpression+"*"+num.substring(index, index+1), curValue3, curPriorityValue3, curExpression.length());
        
        }
    }
}
