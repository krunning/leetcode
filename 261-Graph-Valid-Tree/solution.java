public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || n < 0 ){
            return false;
        }
        if(n - 1 != edges.length){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
                return false;
            }else{
                uf.union(edges[i][0], edges[i][1]);
            }
        }
        return true;
    }
    class UnionFind{
        Map<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < n; i++){
                father.put(i, i);
            }
        }
        public int find(int f1){
            int fa = father.get(f1);
            while(fa != father.get(fa)){
                fa = father.get(fa);
            }
            int cur = f1;
            int tmp = -1;
            while(cur != father.get(cur)){
                tmp = father.get(cur);
                father.put(cur, fa);
                cur = tmp;
            }
            return fa;
        }
        public void union(int f1, int f2){
            int father1 = find(f1);
            int father2 = find(f2);
            father.put(father1, father2);
        }
    }
}