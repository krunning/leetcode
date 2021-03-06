public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i ++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1 = 0, p2 = 0;
        int res = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()){
            if(l1.get(p1) > l2.get(p2)){
                res = Math.min(res, l1.get(p1) - l2.get(p2));
                p2 ++;
            }else{
                res = Math.min(res, l2.get(p2) - l1.get(p1));
                p1 ++;
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");