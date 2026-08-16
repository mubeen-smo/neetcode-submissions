class MedianFinder {
    private PriorityQueue<Integer> maxHeap; 
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
// Intuitive Placement:
if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
    maxHeap.offer(num); // Small numbers go to the small half
} else {
    minHeap.offer(num); // Large numbers go to the large half
}

// Simple Balancing:
if (maxHeap.size() > minHeap.size() + 1) {
    minHeap.offer(maxHeap.poll());
} else if (minHeap.size() > maxHeap.size()) {
    maxHeap.offer(minHeap.poll());
}

    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
