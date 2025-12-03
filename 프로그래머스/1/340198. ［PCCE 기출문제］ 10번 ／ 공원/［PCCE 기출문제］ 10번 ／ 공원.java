import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        // 빈 자리면 1, 사람이 있으면 0
        int[][] empty = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                empty[i][j] = park[i][j].equals("-1") ? 1 : 0;
            }
        }

        // 2차원 누적합 ps[i+1][j+1] = (0,0) ~ (i,j) 합
        int[][] ps = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += empty[i][j];
                ps[i + 1][j + 1] = ps[i][j + 1] + rowSum;
            }
        }

        // mats 내림차순 정렬
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int k = mats[idx];
            if (k > n || k > m) continue; // 공원보다 큰 돗자리는 못 깜

            int target = k * k;
            boolean found = false;

            // (i, j)를 왼쪽 위로 하는 k x k 영역 검사
            for (int i = 0; i <= n - k && !found; i++) {
                for (int j = 0; j <= m - k; j++) {
                    int sum = getSum(ps, i, j, i + k, j + k);
                    if (sum == target) {
                        return k; // 전부 빈자리
                    }
                }
            }
        }

        // 깔 수 있는 돗자리가 없음
        return -1;
    }

    // ps로부터 [x1, x2), [y1, y2) 구간 합 구하기
    private int getSum(int[][] ps, int x1, int y1, int x2, int y2) {
        return ps[x2][y2] - ps[x1][y2] - ps[x2][y1] + ps[x1][y1];
    }
}
