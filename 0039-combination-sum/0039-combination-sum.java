class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combination(0,candidates , 0, target,  new ArrayList<>(), res);
        return res;
    }

    void combination(int i ,int[] arr, int  sum ,int target, List<Integer> ans,List<List<Integer>> res ){
        if(i == arr.length){
            if(sum == target){
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        //nahi lena hi
          combination(i + 1, arr, sum, target, ans, res);

        // Pick
        if (sum + arr[i] <= target) {
            ans.add(arr[i]);
            sum += arr[i];

            combination(i, arr, sum, target, ans, res);

            // Backtrack
            ans.remove(ans.size() - 1);
            sum -= arr[i];
        }
    }
}