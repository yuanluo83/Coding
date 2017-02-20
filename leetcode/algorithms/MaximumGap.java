package algorithms;

import java.util.HashMap;
import java.util.Set;

public class MaximumGap {
	public int maximumGap(int[] num) {
        //HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
        if(num.length<2){
            return 0;
        }else if(num.length==2){
        	return num[1]-num[0];
        }
        
        //boolean[] check = new boolean[Integer.MAX_VALUE];
        
        int max=num[0],min=num[0];
        int maxIndex=0,minIndex=0;
        for (int i=0;i<num.length;i++){
        	if(max<num[i]){max=num[i];maxIndex=i;}
        	if(min>num[i]){min=num[i];minIndex=i;}
            //hm.put(num[i],0);
        	//check[i]=true;
        }
        
        if (max-min == 0) return 0;
        
        //Create num.length-1 bucket for num.length-2 numbers. Each bucket contains a min and max value.
        
        int bucketNum=num.length-1;
        int bucketSize=(int) Math.floor((max-min-1)/bucketNum);
        if(bucketSize==0){
        	bucketSize=1;
        	bucketNum=max-min;
        }
        
        int[][] bucket =new int[bucketNum][3];
                
        //Caculate which bucket to go.
        int index;

        System.out.println(max);
        System.out.println(min);
        System.out.println(bucket.length);
        System.out.println(bucketSize);

        int upper=max;
        
        for(int i=0;i<num.length;i++){
        	if(i!=maxIndex&&i!=minIndex){
        		if(num[i]>min+bucketNum*bucketSize){
            		if(upper>num[i]){
            			upper=num[i];
            		}
            	}else{
	        		index=(int)Math.floor((num[i]-min-1)/bucketSize<0?0:(num[i]-min-1)/bucketSize);
	        		if(bucket[index][0]==0){
	        			bucket[index][1]=bucket[index][2]=num[i];
	        			bucket[index][0]=1;
	        		}else{
	        			if(num[i]<bucket[index][1]){
	        				bucket[index][1]=num[i];
	        			}
	        			if(num[i]>bucket[index][2]){
	        				bucket[index][2]=num[i];
	        			}
	        		}
            	}
        	}
        }
        boolean emptyBucket=false;
        int maxEmptyBucket=0;
        int MaxEmptyBucketUpperBound=-1;
        int countEmptyBucket=0;
        int maxGap=0;
        int tempGap=0;
        
        for(int i=0;i<bucketNum;i++){

        	System.out.print("bucket id:");
        	System.out.print(i);
        	System.out.print(" hasValue:");
        	System.out.print(bucket[i][0]);
        	System.out.print(" min:");
        	System.out.print(bucket[i][1]);
        	System.out.print(" max:");
        	System.out.println(bucket[i][2]);

        	if(bucket[i][0]==0&&emptyBucket){
        		countEmptyBucket++;
        		MaxEmptyBucketUpperBound=i;
    		}else if(bucket[i][0]==1&&emptyBucket){
        		emptyBucket=false;
        		tempGap=getGap(upper, bucket, MaxEmptyBucketUpperBound, countEmptyBucket, bucketNum, max, min);
    			if(tempGap>maxGap){
    				maxGap=tempGap;
    			}
    			countEmptyBucket=0;
    			
        	}else if(bucket[i][0]==0&&!emptyBucket){
        		countEmptyBucket=1;
        		MaxEmptyBucketUpperBound=i;
    			emptyBucket=true;
        	}
        }
        if(emptyBucket&&maxEmptyBucket<countEmptyBucket){
        	tempGap=getGap(upper, bucket, MaxEmptyBucketUpperBound, countEmptyBucket, bucketNum, max, min);
			if(tempGap>maxGap){
				maxGap=tempGap;
			}
			countEmptyBucket=0;
			
		}
        
        
        		
        return maxGap;
        
    }
	
	public int getGap(int upper, int[][] bucket, int MaxEmptyBucketUpperBound, int countEmptyBucket, int bucketNum, int max, int min){
		int maxGap;
		if(countEmptyBucket==0){
        	return max-bucket[bucketNum-1][2];
        }
		int MaxEmptyBucketLowerBound=MaxEmptyBucketUpperBound-(countEmptyBucket-1);
		
         
        if(MaxEmptyBucketLowerBound==0){
        	maxGap = bucket[MaxEmptyBucketUpperBound+1][1]-min;
        }else if(MaxEmptyBucketUpperBound==bucketNum-1){
        	maxGap = upper-bucket[MaxEmptyBucketLowerBound-1][2];
        }else{
        	maxGap = bucket[MaxEmptyBucketUpperBound+1][1]-bucket[MaxEmptyBucketLowerBound-1][2];
        }
        
        System.out.print("MaxEmptyBucketUpperBound:");
        System.out.println(MaxEmptyBucketUpperBound);
        System.out.print("MaxEmptyBucketLowerBound:");
        System.out.println(MaxEmptyBucketLowerBound);
        System.out.print("countEmptyBucket:");
        System.out.println(countEmptyBucket);
        System.out.println("TempGap:");
        System.out.println(maxGap);
        
        return maxGap;
	}
	
	public static void main(String[] args) {
		//int[] num = {601408776,63967816,431363697,242509930,15970592,60284088,228037800,147629558,220782926,55455864,456541040,106650540,17290078,52153098,103139530,294196042,16568100,426864152,61916064,657788565,166159446,1741650,101791800,28206276,6223796,524849590,125389882,84399672,153834912,164568204,1866165,283209696,560993994,16266096,219635658,9188983,485969304,782013650,120332636,44659356,444517408,36369045,47370708,18542592,98802990,137690000,124889895,56062800,265421676,309417680,4634176,801661539,510541206,258227892,398938089,47255754,152260962,409663140,102847688,45756553,377936600,269498,375738702,263761134,53797945,329493948,224442208,508336845,189507850,40944620,127879560,119629476,186894520,62409156,693721503,4289916,523899936,28955240,266488028,20356650,40769391,483694272,97988044,84102,67246047,310688630,41288643,58965588,42881432,152159462,94786355,174917835,119224652,525034376,261516,274800528,62643819,23613832,8397240,797832131,855155367,337066320,26341480,61932200,20661075,515542796,390337500,522552030,43538516,150800550,116747540,152989123,488640056,700610304,233604,344277340,21439176,9397864,16365822,73027584,453041413,197374275,157735188,15273822,187081152,379611084,865005504,223099767,80478651,377729400,186738219,34738263,16634072,112791343,99631856,119364960,477106486,583953920,624509809,188442472,294181256,213023715,146645884,149530380,497592753,132170327,72770643,126683010,405141255,590214306,26670714,95582385,162080790,231120099,8946432,204967980,592849110,54120698,375915096,602145859,5346440,226337825,425156369,653591624,578483360,572410800,32290700,381384563,149939976,183225375,155695620,38307636,457513760,97085778,75200576,8068176,221650296,556889418,252495726,895020231,19932465,156334887,191383314,348432526,368701264,14315598,148936587,279419435,237325542,252587218,322929504,26331343,355297676,600420786,652017765,51673622,159015675};
		//int[] num = {12115,10639,2351,29639,31300,11245,16323,24899,8043,4076,17583,15872,19443,12887,5286,6836,31052,25648,17584,24599,13787,24727,12414,5098,26096,23020,25338,28472,4345,25144,27939,10716,3830,13001,7960,8003,10797,5917,22386,12403,2335,32514,23767,1868,29882,31738,30157,7950,20176,11748,13003,13852,19656,25305,7830,3328,19092,28245,18635,5806,18915,31639,24247,32269,29079,24394,18031,9395,8569,11364,28701,32496,28203,4175,20889,28943,6495,14919,16441,4568,23111,20995,7401,30298,2636,16791,1662,27367,2563,22169,1607,15711,29277,32386,27365,31922,26142,8792};
		//int[] num ={100,3,2,1};
		//int[] num = {1,1,1,1,1,5,5,5,5,5};
		//int[] num = {6, 3, 1, 9};
		int[] num = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
		MaximumGap maximumGap=new MaximumGap();
		int max= maximumGap.maximumGap(num);
		System.out.println(max);
	}
}
