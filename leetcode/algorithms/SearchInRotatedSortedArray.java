package algorithms;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        return searchHelp(nums, 0, nums.length-1, target);
    }
    public int searchHelp(int[] nums, int begin, int end, int target){
        if (end-begin<=1){
            //System.out.println(begin+"  "+end);
            if (nums[begin] == target){
                return begin;
            } else if (nums[end] == target){
                return end;
            } else {
                return -1;
            }
        }
        int mid = begin + (end - begin)/2;
        //System.out.println(begin+" "+mid+" "+end);
        if (target<=nums[mid]){ 
            if (nums[begin]<=nums[mid]) {
                int leftSearchResult = searchHelp(nums, begin, mid, target);
                int rightSearchResult = searchHelp(nums, mid+1, end, target);
                if (leftSearchResult==-1){
                    return rightSearchResult;
                } else if(rightSearchResult==-1) {
                    return leftSearchResult;
                }
                return leftSearchResult;
            } else {
                return searchHelp(nums, begin, mid, target);
            }
        } else {
            if (nums[begin]<=nums[mid]) {
                return searchHelp(nums, mid+1, end, target);
            } else {
                int leftSearchResult = searchHelp(nums, begin, mid, target);
                int rightSearchResult = searchHelp(nums, mid+1, end, target);
                if (leftSearchResult==-1){
                    return rightSearchResult;
                } else if(rightSearchResult==-1) {
                    return leftSearchResult;
                }
                return leftSearchResult;
            }
        }
    }
}
