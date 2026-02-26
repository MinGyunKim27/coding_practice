class Solution {
    public int solution(int n) {
        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= n) {
            if (sum == n) {
                count++;
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        return count;
    }
}