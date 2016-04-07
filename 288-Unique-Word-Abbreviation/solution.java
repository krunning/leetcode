public class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String s : dictionary){
            String abbr = getAbbr(s);
            if(map.containsKey(abbr) && !map.get(abbr).equals(s)){
                map.put(abbr, "");
            }else{
                map.put(abbr, s);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(map.containsKey(abbr) && map.get(abbr).equals(word) || !map.containsKey(abbr)){
            return true;
        }
        return false;
    }
    private String getAbbr(String s){
        if(s.length() > 2){
            return new StringBuilder().append(s.charAt(0))
                                      .append(s.length() - 2)
                                      .append(s.charAt(s.length() - 1))
                                      .toString();
        }
        return s;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");