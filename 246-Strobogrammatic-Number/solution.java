public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        int start = 0, end = num.length() - 1;
        while(start <= end){
            if(!check(num.charAt(start), num.charAt(end))){
                return false;
            }else{
                start ++;
                end --;
            }
        }
        return true;
    }
    private boolean check(char c1, char c2){
        if(c1 == '6'){
            return c2 == '9';
        }
        if(c1 == '1' || c1 == '8' || c1 == '0'){
            return c2 == c1;
        }
        if(c1 == '9'){
            return c2 == '6';
        }
        return false;
    }
}