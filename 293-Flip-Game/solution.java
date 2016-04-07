public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 1){
            return res;
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == chars[i + 1] && chars[i] == '+'){
                res.add(flip(i, chars));
                chars[i] = chars[i + 1] = '+';
            }
        }
        return res;
    }
    private String flip(int i, char[] chars){
        chars[i] = chars[i+1] = '-';
        return String.valueOf(chars);
    }
}