public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while(start <= end){
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;
        }
        return new String(chars);
    }
}