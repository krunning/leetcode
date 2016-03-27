import java.util.Map.Entry;
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int odd = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1 + map.get(s.charAt(i)));
            }else{
                map.put(s.charAt(i), 1);
            }
            odd += map.get(s.charAt(i)) % 2 == 0 ? -1 : 1;
        }
        if(odd > 1) return res;
        List<Character> chars = new ArrayList<Character>();
        String mid = "";
        for(Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0){
                mid += entry.getKey();
            {
            for(int i = 0; i < entry.getValue() / 2; i++)
                chars.add(entry.getKey());
        }
        helper(chars, mid, new boolean[chars.size()], new StringBuffer(), res);
        return res;
    }
    private void helper(List<Character> chars, String mid ,boolean[] visited, StringBuffer sb, List<String> res){
        if(sb.length() == chars.size()){
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for(int i = 0; i < chars.size(); i++){
            if(visited[i] || i != 0 && chars.get(i - 1) == chars.get(i) && !visited[i - 1]){
                continue;
            }
            visited[i] = true;
            helper(chars, mid, visited, sb.append(chars.get(i)), res);
            visited[i] = false;
        }
    }
}