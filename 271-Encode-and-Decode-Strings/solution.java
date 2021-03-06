public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String> ();
        int i = 0;
        while(i < s.length()){
            int slash = s.indexOf("/", i);
            int len = Integer.valueOf(s.substring(i,slash));
            res.add(s.substring(slash + 1, len + slash + 1));
            i = slash + len + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));