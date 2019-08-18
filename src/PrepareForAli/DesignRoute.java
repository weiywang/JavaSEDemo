package PrepareForAli;

import java.util.Scanner;

public class DesignRoute {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int m = input.nextInt();
            long[][] map = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = input.nextLong();
                }
            }
            long[][] res = new long[n][n];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < n; i++) {
                int nowrow = i;
                int nowcol = i;
                int distance = 0;
                solve(nowcol, m, map, res, distance, nowrow);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }

        }

        public static void solve(int nowcol, int m, long[][] map, long[][] res, long distance, int nowrow) {
            if (m == 0) {
                if (distance < res[nowrow][nowcol]) {
                    res[nowrow][nowcol] = distance;
                    return;
                }
                return;
            }
            for (int nextcol = 0; nextcol < map[0].length; nextcol++) {
                if (nowcol != nextcol) {
                    solve(nextcol, m - 1, map, res, distance + map[nowcol][nextcol], nowrow);
                }
            }
            return;
        }
}
