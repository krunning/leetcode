public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.getCharArray();
        int start = 0;
        int end = chars.length - 1;
        while(start <= end){
            if(isVowel(chars[start]) && isVowel(chars[end])){
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start ++;
                end --;
            }else if(!isVowel(chars[start]){
                start++;
            }else{
                end--;
            }
        }
        return new String(chars);
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}