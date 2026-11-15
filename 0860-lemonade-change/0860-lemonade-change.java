class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0, tens = 0, twenty = 0;

        for(int i : bills){
           // if(i > five) return false;
            if(i == 5){
                five++;
            }

            if(i == 10){
                if(five == 0) return false;
                tens++;
                five--;   
            }

            if(i == 20){
                if(tens > 0){
                    tens--;
                    if(five == 0) return false;
                    five--;
                }
                else if(five < 3) return false;

                else five -= 3;
      
            }
        }
        return true;
    }
}