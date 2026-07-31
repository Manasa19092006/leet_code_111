import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});

                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] cur = queue.poll();

                for (int[] d : dir) {

                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x >= 0 && x < rows &&
                        y >= 0 && y < cols &&
                        grid[x][y] == 1) {

                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}