class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones) {
            maxHeap.add(n);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x != y) {
                maxHeap.add( x - y);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
