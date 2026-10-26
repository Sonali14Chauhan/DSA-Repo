class Solution {
    public List<String> letterCombinations(String digits) {
     // char[] digit  = digits.toCharArray();
      HashMap<Character, String> map = new HashMap<>();
      map.put('2',"abc");
      map.put('3',"def");
      map.put('4',"ghi"); 
      map.put('5',"jkl");
      map.put('6',"mno");
      map.put('7',"pqrs");
      map.put('8',"tuv");
      map.put('9',"wxyz");

      List<String> ans = new ArrayList<>();
      combination(map, ans,  new StringBuilder(), digits, 0);
      return ans;
    }

    void combination(HashMap<Character, String> map, List<String> ans, StringBuilder s, String d, int i){
        if(i == d.length()) {
            ans.add(s.toString());
            return;
        }

        String choice = map.get(d.charAt(i));
        for(int j=0; j<choice.length(); j++){
            s.append(choice.charAt(j));
            combination(map, ans, s, d, i+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
