class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Step 1: Use an Integer array to keep track of original indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Step 2: Sort indices based on car positions in descending order
        // (Cars closest to the target are evaluated first)
        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));
        
        int fleetCount = 0;
        double maxTimeNeeded = 0.0; // Acts as our virtual "stack top"
        
        // Step 3: Track fleets without using a collection stack
        for (int index : indices) {
            double currentCarTime = (double) (target - position[index]) / speed[index];
            
            // If the current car takes longer than the fleet ahead, 
            // it cannot catch up and must initiate a new fleet.
            if (currentCarTime > maxTimeNeeded) {
                fleetCount++;
                maxTimeNeeded = currentCarTime;
            }
        }
        
        return fleetCount;
    }
}
