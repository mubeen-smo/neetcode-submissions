class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]), (a[0]*a[0] + a[1] * a[1]))
        );
        for(int i = 0; i < points.length; i++) {
            int currDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(maxHeap.size() == k) {
            int[] top = maxHeap.peek();
            int distTop = top[0]*top[0] + top[1] * top[1];
                if(currDist < distTop) {
                   maxHeap.poll();
                   maxHeap.offer(points[i]);
                }
            } else maxHeap.offer(points[i]);
        }
        int i = 0;
        while(maxHeap.size() > 0) {
            result[i++] = maxHeap.poll();
        }
        return result;
    }
}
