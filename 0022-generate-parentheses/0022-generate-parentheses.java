class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int o, int c, int n, String s, List<String> res){
        if(o == n && c == n){
             res.add(s);
             return;
            
        }
        if(o < n){
            generate(o+1, c, n, s + '(', res);
        }

        if(c < o){
            generate(o, c+1, n, s + ')', res);
        }
    }
}