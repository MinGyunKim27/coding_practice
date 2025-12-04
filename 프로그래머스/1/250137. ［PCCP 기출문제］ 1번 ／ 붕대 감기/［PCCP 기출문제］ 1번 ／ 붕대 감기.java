class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int maxHealth = health;
        int curHealth = health;

        int combo = 0;        // 연속 성공 시간(초)
        int attackIdx = 0;    // attacks 배열 인덱스
        int lastTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간

        // 1초부터 마지막 공격 시간까지 시뮬레이션
        for (int time = 1; time <= lastTime; time++) {
            // 이번 초에 공격이 있는 경우
            if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
                int damage = attacks[attackIdx][1];
                curHealth -= damage;

                // 체력이 0 이하가 되면 사망
                if (curHealth <= 0) {
                    return -1;
                }

                // 붕대 연속 성공 시간 초기화
                combo = 0;
                attackIdx++;
            } else {
                // 공격이 없으면 붕대 감기 성공
                combo++;
                curHealth += x; // 초당 회복

                // t초 연속 성공 시 추가 회복
                if (combo == t) {
                    curHealth += y;
                    combo = 0; // 연속 성공 시간 초기화
                }

                // 최대 체력 초과 불가
                if (curHealth > maxHealth) {
                    curHealth = maxHealth;
                }
            }
        }

        // 모든 공격이 끝난 직후 남은 체력
        return curHealth;
    }
}
