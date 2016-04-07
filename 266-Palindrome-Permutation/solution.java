public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        boolean flag = false;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(flag && entry.getValue() % 2 == 1){
                return false;
            }else if(entry.getValue() % 2 == 1){
                flag = true;
            }
        }
        return true;
    }
}