import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        // 시작 위치 찾기
        int r = 0, c = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        // 방향 벡터
        Map<Character, int[]> dir = new HashMap<>();
        dir.put('N', new int[]{-1, 0});
        dir.put('S', new int[]{ 1, 0});
        dir.put('W', new int[]{ 0,-1});
        dir.put('E', new int[]{ 0, 1});

        for (String route : routes) {
            String[] parts = route.split(" ");
            char op = parts[0].charAt(0);
            int n = Integer.parseInt(parts[1]);

            int[] d = dir.get(op);
            int nr = r, nc = c;
            boolean ok = true;

            // 한 칸씩 검사하며 이동
            for (int step = 0; step < n; step++) {
                nr += d[0];
                nc += d[1];

                // 공원 밖
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    ok = false;
                    break;
                }
                // 장애물
                if (park[nr].charAt(nc) == 'X') {
                    ok = false;
                    break;
                }
            }

            // 문제 없을 때만 위치 갱신
            if (ok) {
                r = nr;
                c = nc;
            }
        }

        return new int[]{r, c};
    }
}
