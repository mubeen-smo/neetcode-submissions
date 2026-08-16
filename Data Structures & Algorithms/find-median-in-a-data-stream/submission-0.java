class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    int minSize;
    int maxSize;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        minHeap = new PriorityQueue<>();
        minSize = 0;
        maxSize = 0;
    }
    
    public void addNum(int num) {
        if(minSize == 0) {
            minHeap.offer(num);
            minSize++;
            return;
        }
        if(minHeap.peek() < num) {
            if(minSize > maxSize) {
                maxHeap.offer(minHeap.poll());
                maxSize = maxHeap.size();
            }
            minHeap.offer(num);
            minSize = minHeap.size();
        } else {
            if(maxSize > minSize) {
                minHeap.offer(maxHeap.poll());
                minSize = minHeap.size();
            }
            maxHeap.offer(num);
                maxSize = maxHeap.size();
        }
    }
    
    public double findMedian() {
        double minM = minHeap.peek() == null ? 0 : (double) minHeap.peek();
        double maxM =  maxHeap.peek() == null ? 0 : (double) maxHeap.peek();
        if(minSize > maxSize ) {
            return minM;
        }
        else if(minSize < maxSize) {
            return maxM;
        } 
        else {
            return (minM + maxM)/2;
        }
    }
}
