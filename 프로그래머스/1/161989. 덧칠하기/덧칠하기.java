class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int paintedUntil = 0; // 여기까지(포함) 칠해져 있음. (1~n 구역 번호 기준)

        for (int s : section) {
            // s가 아직 칠해진 범위 밖이면 새로 칠해야 함
            if (s > paintedUntil) {
                count++;
                paintedUntil = s + m - 1; // s부터 롤러 길이 m으로 칠한 끝 지점
            }
        }
        return count;
    }
}
