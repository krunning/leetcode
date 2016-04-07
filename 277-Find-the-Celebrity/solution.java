/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i ++){
            if(!knows(i, candidate)){
                //in this case, i maybe the celebrity, but the current candidate can't be the celebrity
                candidate = i;
            }
        }
        // verify whether there is a celebrity
        for(int i = 0; i < n; i ++){
            if(candidate == i){
                continue;
            }
            if(knows(candidate, i) || !knows(i, candidate)){
                return -1;
            }
        }
        return candidate;
    }
}