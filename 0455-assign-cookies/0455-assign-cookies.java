class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0 , i=0, j=0;
        Arrays.sort(s);
        Arrays.sort(g);
        while(i<g.length && j<s.length){
            if(s[j] >= g[i]){
                res++; j++; i++;
            } else j++;
        }
        return res;
    }
}