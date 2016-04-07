public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null) return 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length()){
                char c = s.charAt(j);
                if(map.size() < k || map.containsKey(c)){
                    if(map.containsKey(c)){
                        map.put(c, map.get(c) + 1);
                    }else{
                        map.put(c, 1);
                    }
                    j++;
                }else{
                    break;
                }
            }
            max = Math.max(max, j - i);
            if(map.get(s.charAt(i)) == 1){
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        return max;
    }
}