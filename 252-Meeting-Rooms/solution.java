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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1){
            return true;
        }
        Comparator<Interval> c = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        Arrays.sort(intervals, c);
        Interval pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < pre.end){
                return false;
            }
            pre = intervals[i];
        }
        return true;
    }
}
