public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(!word1.equals(word2)){
                if(word1.equals(words[i])){
                    p1 = i;
                }
                if(word2.equals(words[i])){
                    p2 = i;
                }
            }else{
                if(word1.equals(words[i]) && (p1 == -1 || p2 > p1)){
                    p1 = i;
                }else if(word1.equals(words[i])){
                    p2 = i;
                }
            }
            if(p1 != -1 && p2 != -1){
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}