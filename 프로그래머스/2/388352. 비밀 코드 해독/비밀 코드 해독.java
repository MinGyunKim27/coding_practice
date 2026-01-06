import java.util.*;

class Solution {
    int n;
    int[][] q;
    int[] ans;
    int m;
    int result = 0;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.m = q.length;

        // 1~n 중 5개 조합 생성
        comb(1, 0, new int[5]);
        return result;
    }

    // 조합 생성
    private void comb(int start, int depth, int[] selected) {
        if (depth == 5) {
            if (isValid(selected)) {
                result++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            comb(i + 1, depth + 1, selected);
        }
    }

    // 해당 조합이 모든 시도를 만족하는지 검사
    private boolean isValid(int[] selected) {
        // 빠른 비교를 위해 Set 사용
        Set<Integer> set = new HashSet<>();
        for (int num : selected) {
            set.add(num);
        }

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int num : q[i]) {
                if (set.contains(num)) {
                    count++;
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
