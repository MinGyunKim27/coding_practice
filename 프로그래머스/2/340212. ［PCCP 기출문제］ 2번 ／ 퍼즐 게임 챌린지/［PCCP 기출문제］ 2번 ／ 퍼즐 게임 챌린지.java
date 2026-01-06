class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;

        int left = 1;
        int right = 0;
        for (int d : diffs) {
            right = Math.max(right, d);
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canSolve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];

            if (diff <= level) {
                totalTime += timeCur;
            } else {
                int fail = diff - level;
                int timePrev = (i == 0) ? 0 : times[i - 1];
                totalTime += (long) fail * (timeCur + timePrev) + timeCur;
            }

            if (totalTime > limit) return false;
        }

        return true;
    }
}
