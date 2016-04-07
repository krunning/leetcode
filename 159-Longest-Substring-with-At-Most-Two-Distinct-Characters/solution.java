public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            while(j < s.length()){
                char tmp = s.charAt(j);
                if(map.size() < 2 || map.containsKey(tmp)){
                    if(map.containsKey(tmp)){
                        map.put(tmp, map.get(tmp) + 1);
                    }else{
                        map.put(tmp, 1);
                    }
                }else{
                    break;                    
                }
                j++;
            }
            res = Math.max(res, j - i);
            if(map.get(cur) == 1){
                map.remove(cur);
            }else{
                map.put(cur, map.get(cur) - 1);
            }
        }
        return res;
    }
}