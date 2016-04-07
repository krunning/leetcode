public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int fast = 0, slow = 0;
        while(fast < s.length){
            if(s[fast] == ' '){
                reverse(s, slow, fast - 1);
                fast ++;
                slow = fast;
            }else{
                fast ++;
            }
        }
        reverse(s, slow, fast - 1);
    }
    private void reverse(char[] s, int start, int end){
        while(start <= end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start ++;
            end --;
        }
    }
}