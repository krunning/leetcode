public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        List<String> list = new ArrayList<String>();
        for(int i = low.length(); i <= high.length(); i++){
            list.addAll(helper(i, i));
        }
        for(String s : list){
            if(s.length() == low.length() && s.compareTo(low) < 0 || s.length() == high.length() && s.compareTo(high) > 0){
                continue;
            }
            res ++;
        }
        return res;
    }
    private List<String> helper(int n, int m){
        if(n == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(n == 1){
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            String tmp = list.get(i);
            if(n != m){
                res.add("0" + tmp + "0");
            }
            res.add("1" + tmp + "1");
            res.add("8" + tmp + "8");
            res.add("6" + tmp + "9");
            res.add("9" + tmp + "6");
        }
        return res;
    }
}