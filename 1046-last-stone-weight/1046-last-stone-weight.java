class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int num: stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            int largest = pq.poll();
            int secondLargest = pq.poll();

            if(largest != secondLargest){
                pq.offer(largest - secondLargest);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}