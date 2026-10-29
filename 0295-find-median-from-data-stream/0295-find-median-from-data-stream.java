class MedianFinder {

    // Max heap: smaller half
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());

    // Min heap: larger half
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        // Step 1: Insert into the appropriate heap
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } 
        else {
            large.offer(num);
        }

        // Step 2: Balance the heaps
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } 
        else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // Odd number of elements
        if (small.size() > large.size()) {
            return small.peek();
        }

        // Even number of elements
        return ((double) small.peek() + large.peek()) / 2.0;
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */