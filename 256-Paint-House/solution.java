public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        for(int i = 1; i < costs.length; i ++){
            int curR = Math.min(lastG, lastB) + costs[i][0];
            int curG = Math.min(lastR, lastB) + costs[i][1];
            int curB = Math.min(lastG, lastR) + costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(lastR, Math.min(lastB, lastG));
    }
}
/*
Define lastR as the total minimum cost to pain previous hourses and paint current house Red
*/
