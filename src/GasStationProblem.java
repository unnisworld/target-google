
public class GasStationProblem {

	public static void main(String[] args) {
		int[] gas  = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		
//		int[] gas  = new int[] {2,3,4};
//		int[] cost = new int[] {3,4,3};
		
		int gIndex = canCompleteCircuit(gas, cost);
		
		System.out.println("Index "+ gIndex);
	}
	
	static int findIndex(int[] gas, int[] cost) {

		for(int i=0;i<gas.length;i++) {

			if (gas[i] < cost[i]) {
				continue;
			}
			
			int tank = 0;
			int startStation = i;
			int currentStation = i;
			for(int j=i+1;j<gas.length;) {
				tank += gas[currentStation];
				if (tank <= 0) {
					break;
				}
				tank -= gas[j];
				currentStation = j;
				
				if (startStation == currentStation) {
					return startStation;
				}
				
				j++;
				if (j==gas.length) {
					j = 0;
				}
			}

		}
		
		return -1;
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
	    int n = gas.length;

	    int total_tank = 0;
	    int starting_station = 0;
	    for (int i = 0; i < n; ++i) {
	      // if total(gas) - total(cost) < 0, then trip is not possible.	
	      total_tank += gas[i] - cost[i];

	      if ((gas[i] - cost[i]) < 0) {
	        // A station without enough gas cannot be selected as starting station.
	        starting_station = i + 1;
	      }
	    }
	    return total_tank >= 0 ? starting_station : -1;
	  }
	

}
