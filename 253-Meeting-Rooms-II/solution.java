/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length <= 0){
            return 0;
        }
        List<Pair> pairs = new ArrayList<Pair>();
        Comparator<Pair> c = new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                if(p1.time != p2.time){
                    return p1.time - p2.time;
                }else{
                    return p1.isStart ? 1 : -1;
                }
            }
        };
        for(Interval i : intervals){
            pairs.add(new Pair(i.start, true));
            pairs.add(new Pair(i.end, false));
        }
        Collections.sort(pairs, c);
        int max = 0;
        int count = 0;
        for(Pair p : pairs){
            if(p.isStart){
                count++;
            }else{
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    class Pair{
        int time;
        boolean isStart;
        Pair(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;
        }
    }
}