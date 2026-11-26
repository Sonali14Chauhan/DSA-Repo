class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n-1]-position[0];

        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(mid, position, m)){
                low  = mid +  1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }

    boolean isPossible(int dis, int a[], int balls){
        int lastPos =  a[0], count=1;
        for(int i=1; i<a.length; i++){
            if( (a[i]- lastPos) >=  dis){
                count++;
                lastPos = a[i];
            }
        }
        return count >= balls;
    }
}