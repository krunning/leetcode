public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int minLen = Math.min(s.length(), t.length());
        for(int i = 0; i < minLen; i++){
            if(s.charAt(i) != t.charAt(i)){
                //s.length() == t.length(), so should be modified
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                    //delete
                }else if(s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                    //delete
                }else{
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        // the only possible is there are one more character
        return Math.abs(s.length() - t.length()) == 1;
    }
}