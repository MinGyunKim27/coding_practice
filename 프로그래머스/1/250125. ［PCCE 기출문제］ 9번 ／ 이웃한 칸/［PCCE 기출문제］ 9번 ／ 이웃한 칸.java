class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;          // 보드 한 변의 길이
        int count = 0;                 // 같은 색 개수

        // 상하좌우 이동 (오른쪽, 아래, 위, 왼쪽)
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        String color = board[h][w];    // 기준 칸의 색

        for (int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];

            // 보드 범위 체크
            if (hCheck >= 0 && hCheck < n && wCheck >= 0 && wCheck < n) {
                if (board[hCheck][wCheck].equals(color)) {
                    count++;
                }
            }
        }

        return count;
    }
}
