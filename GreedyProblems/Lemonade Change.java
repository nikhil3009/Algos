class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int tens = 0;

        for(int bill:bills){
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five > 0){
                    five--;
                    tens++;
                }
                else{
                    return false;
                }
            }
            else{
                if(tens>0 && five>0){
                    tens--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }

            }

        }
        return true;
    }
}