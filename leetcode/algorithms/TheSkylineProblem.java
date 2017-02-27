package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TheSkylineProblem {
	
	public List<int[]> getSkyline(int[][] buildings) {
		TreeMap<Integer,Integer> xMap = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> yMap = new TreeMap<Integer,Integer>();
		ArrayList<int[]> result = new ArrayList<int[]>();
		
		for (int i=0; i< buildings.length; i++) {					
			while (!xMap.isEmpty() && xMap.firstKey()<buildings[i][0]){
				Map.Entry<Integer,Integer> xEntry = xMap.pollFirstEntry();
				int x = xEntry.getKey();
				int y = xEntry.getValue();
				if (yMap.containsKey(y) && yMap.get(y) <= x){yMap.remove(y);}
				if (xMap.isEmpty() ){
					int[] r = new int[2];
					r[0] = x;
					r[1] = 0;
					result.add(r);
					
				} else if ( !yMap.isEmpty() && yMap.lastKey() < y ) {
					int[] r = new int[2];
					r[0] = x;
					while (!yMap.isEmpty() && yMap.lastEntry().getValue() <= x){
						yMap.pollLastEntry();
					}
					r[1] = yMap.lastKey();
					result.add(r);
				}
			}
			int maxY = buildings[i][2];
			int lastY = -1;
			if (!yMap.isEmpty()) lastY=yMap.lastKey();
			if (i < buildings.length - 1) {
				while (i < (buildings.length - 1) && buildings[i][0] == buildings[i+1][0]){
					if (!yMap.containsKey(buildings[i][2]) || (yMap.get(buildings[i][2]) < buildings[i][1])){
						yMap.put(buildings[i][2],buildings[i][1]);
						//System.out.println("yMap: "+ buildings[i][2] + " " +buildings[i][1]);
					}
					if (!xMap.containsKey(buildings[i][1]) || (xMap.get(buildings[i][1]) < buildings[i][2]))
						xMap.put(buildings[i][1],buildings[i][2]);	
					if (maxY < buildings[i+1][2]) {
						maxY = buildings[i+1][2];
					}
					i++;
				}
			}
			//System.out.println(yMap.lastKey());
			if (xMap.isEmpty() || yMap.isEmpty() || lastY < maxY) {
				int[] r = new int[2];
				r[0] = buildings[i][0];
				r[1] = maxY;
				//System.out.println(r[0] + " x-y " +r[1]);
				result.add(r);
			}
			
			xMap.put(buildings[i][1], maxY);
			if (!yMap.containsKey(buildings[i][2]) || (yMap.get(buildings[i][2]) < buildings[i][1]))
				yMap.put(buildings[i][2],buildings[i][1]);	
	
		}
		
		
		while (!xMap.isEmpty()){			
			Map.Entry<Integer,Integer> xEntry = xMap.pollFirstEntry();
			int x = xEntry.getKey();
			int y = xEntry.getValue();
			//System.out.println(x + " " +y);
			if (yMap.containsKey(y) && yMap.get(y) <= x){
				//System.out.println(x + "-" +y);
				yMap.remove(y);
			}
			if (xMap.isEmpty()){
				int[] r = new int[2];
				r[0] = x;
				r[1] = 0;
				result.add(r);
				
			} else if (!yMap.isEmpty() && yMap.lastKey() < y) {
				int[] r = new int[2];
				r[0] = x;
				while (!yMap.isEmpty() && yMap.lastEntry().getValue() <= x){
					yMap.pollLastEntry();
				}
				r[1] = yMap.lastKey();
				result.add(r);
			}

		}
		return result;
        
    }
    
    public static void main(String[] args) {
    	//int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
    	//int[][] buildings = { {1, 2, 1}, {1, 2, 2}, {1, 2, 3},{1, 3, 2}, {1, 2, 3} };
    	//int[][] buildings = {{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
    	
    	int[][] buildings = {{5951,42679,584900},{7612,460224,165719},{10054,528935,547159},{12434,184263,538819},
    	 {14903,205061,507630},{30168,640118,643081},{52730,67749,544684},{56208,347295,318255},
    	 {57296,500861,788192},{65779,535324,564426},{69626,936712,415579},{77787,785719,327931},
    	 {82254,805279,920649},{86518,383868,930470},{87489,418143,10692},{98967,724391,93083},
    	 {99745,742397,134090},{101345,176839,627338},{116139,360005,261692},{118986,130026,582543},
    	 {122923,470827,554902},{123305,124192,200341},{125932,726376,657081},{137743,889344,943207},
    	 {143009,468012,356768},{144978,404082,31802},{146685,244171,473528},{152385,835275,67458},
    	 {159945,571319,499254},{160872,908174,692144},{164623,315507,76118},{177782,386719,229831},
    	 {180448,787809,497368},{186034,256757,542791},{188402,843895,494935},{197303,894782,801283},
    	 {202312,261398,307960},{202390,308850,114020},{216466,587906,560282},{254738,444539,769109},
    	 {275954,456722,435187},{278192,586784,83534},{279840,472712,598594},{287433,876565,846065},
    	 {318879,922949,183256},{337738,845315,912970},{344100,965430,103653},{350296,779286,126824},
    	 {366521,400209,4075},{367676,911181,784590},{371269,947782,560479},{377942,978066,660521},
    	 {402938,794535,521823},{407536,929952,795747},{409959,457637,251645},{417770,838407,530482},
    	 {425965,790228,56305},{439707,961265,137333},{446176,513487,141989},{455879,582111,663768},
    	 {472532,567342,107840},{492380,561017,757035},{497930,603380,454255},{504632,534547,694128},
    	 {512389,594618,356728},{520832,931989,768018},{525637,997553,817328},{535984,566145,926744},
    	 {569708,631488,207038},{583058,918142,600957},{583928,806005,34478},{591010,851424,292990},
    	 {608726,998069,42301},{610001,658217,97268},{615495,785912,300917},{650994,896338,60267},
    	 {693313,726376,583178},{706898,791076,724417},{709816,928183,750769},{719093,753014,698100},
    	 {720242,773502,113359},{742290,807067,286960},{754791,832571,262145},{763308,855300,66229},
    	 {785215,909931,2177},{787290,818298,269345}};
    	
    	List result = new TheSkylineProblem().getSkyline(buildings);
    	Iterator iter = result.iterator();
    	while (iter.hasNext()) System.out.println( java.util.Arrays.toString((int[]) iter.next()));

	}
}

