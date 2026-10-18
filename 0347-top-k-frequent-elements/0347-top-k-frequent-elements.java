class Solution {
    class Pair{
        int freq, elem;

        Pair(int freq, int elem){
            this.freq = freq;
            this.elem = elem;
        }
    }

    public int[] topKFrequent(int[] nums, int k){

        HashMap<Integer,  Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            (a,  b) ->  {
                if(a.freq != b.freq) return a.freq - b.freq;
                 return a.elem - b.elem;
            }
        );

        for(int key: map.keySet()){
            int f = map.get(key);
            pq.offer(new Pair(f, key));
            if(pq.size() > k){
                pq.poll();
            }
            
        }

        

         int[] arr = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            arr[i] = pq.poll().elem;
        }
        return arr;
    }
}