
public class Solution {
       public int minTotalDistance(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int total = 0, Z[] = new int[m*n];
            for (int dim=0; dim<2; ++dim) {
                int i = 0, j = 0;
                if (dim == 0) {
                    for (int x=0; x<n; ++x)
                        for (int y=0; y<m; ++y)
                            if (grid[y][x] == 1)
                                Z[j++] = x;
                } else {
                    for (int y=0; y<m; ++y)
                        for (int g : grid[y])
                            if (g == 1)
                                Z[j++] = y;
                }
                while (i < --j)
                    total += Z[j] - Z[i++];
            }
            return total;
        }
}