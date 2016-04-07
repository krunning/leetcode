public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0){
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings){
            String key = getBitMap(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    //shift back the string to the original string start with 'a'.
    // ce -> ac  dis = 2
    // eg -> ac  dis = 4
    private String getBitMap(String s){
        StringBuilder sb = new StringBuilder();
        int dis = s.charAt(0) - 'a';
        for(int i = 0; i < s.length(); i++){
            sb.append((s.charAt(i) - 'a' - dis + 26) % 26 + 'a');
        }
        return sb.toString();
    }
}