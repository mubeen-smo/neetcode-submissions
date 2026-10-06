class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int size = position.length;

        Integer[] indices = new Integer[size];

        for(int i = 0; i < size; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));
        int carFleets = 0;
        double leastSoFar = 0.0;
        for(int i : indices) {
            double currentCarTime = (double) (target - position[i])/speed[i];
            if(currentCarTime > leastSoFar) {
                carFleets++;
                leastSoFar = currentCarTime;
            }
        }
        return carFleets;
    }
}
