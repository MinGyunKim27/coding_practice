class Solution {

    // HHMM 형식 정수를 "분"으로 변환
    private int toMinutes(int t) {
        int h = t / 100;
        int m = t % 100;
        return h * 60 + m;
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int wish = schedules[i];               // 희망 출근 시각 (HHMM)
            int limit = toMinutes(wish) + 10;      // 인정 마감 시각(분)

            boolean ok = true;  // 이 직원이 상품 받을 수 있는지

            for (int j = 0; j < 7; j++) {
                // 실제 요일: 1=월, ..., 7=일
                int day = (startday + j - 1) % 7 + 1;

                // 토요일(6), 일요일(7)은 이벤트 영향 없음
                if (day == 6 || day == 7) {
                    continue;
                }

                int arrive = toMinutes(timelogs[i][j]);  // 출근시각(분)

                // 지각하면 이 직원은 탈락
                if (arrive > limit) {
                    ok = false;
                    break;
                }
            }

            if (ok) answer++;
        }

        return answer;
    }
}
