class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Math.abs(x-a) != Math.abs(x-b) ? 
                                                        Math.abs(x-b) - Math.abs(x-a): b-a);
        for(int i: arr){ 
            pq.offer(i);
            if(pq.size() > k) pq.poll(); 
        }
        List<Integer> out = new ArrayList<>(pq);
        Collections.sort(out); // the list as it will be in reverseorder.
        return out;
    }
}