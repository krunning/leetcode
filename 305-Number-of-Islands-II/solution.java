public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(positions == null) return res;
        int num = 0;
        UnionFind unionFind = new UnionFind(m, n);
        int[] dx = {0 ,0 ,1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < positions.length; i++){
            num++;
            int curX = positions[i][0];
            int curY = positions[i][1];
            for(int k = 0; k < 4; k ++){
                int x = dx[k] + curX;
                int y = dy[k] + curY;
                if(isValid(x, y, m, n) && unionFind(convertToId(curX, curY, m)) == unionFind(convertToId(x, y, m))){
                    num --;
                }
            }
            res.add(num);
        }
        return res;
    }
    private boolean isValid(int x, int y, int m, int n){
        if(x < 0 || y < 0 || x >= m || y >= n){
            return false;
        }
        return true;
    }
    class UnionFind{
        HashMap<Integer, Integer> father;
        UnionFind(int m, int n){
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    father.put(convertToId(x, y, m), convertToId(x, y, m));
                }
            }
        }
        public int find(int p){
            int fa = father.get(p);
            while(fa != father.get(fa)){
                fa = father.get(fa);
            }
            int parent = father.get(p);
            while(parent != father.get(parent)){
                int next = father.get(parent);
                father.put(parent, fa);
                parent = next;
            }
            father.put(p, fa);
            return fa;
        }
        public void union(int a, int b){
            fa = find(a);
            fb = find(b);
            father.put(fa,fb);
        }
    }
    private int convertToId(int x, int y, int m){
        return x * m + y;
    }
}