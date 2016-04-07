public class Solution {
    private static final int ROOM = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    
    public void wallsAndGates(int[][] rooms) {
        HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
        Queue<Point> queue = new LinkedList<Point>();
        
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == GATE){
                    queue.offer(new Point(i, j));
                }
            }
        }
        int level = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
                for(int j = 0; j < 4; j++){
                    int x = p.x + dx[j];
                    int y = p.y + dy[j];
                    if(check(rooms, x, y, level + 1)){
                        queue.offer(new Point(x, y));
                        rooms[x][y] = level + 1;
                    }
                }
            }
            level ++;
        }
    }
    private boolean check(int[][] rooms, int x, int y, int level){
        if(x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == WALL 
        || rooms[x][y] !=WALL && rooms[x][y] <= level){
            return false;
        }
        return true;
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}