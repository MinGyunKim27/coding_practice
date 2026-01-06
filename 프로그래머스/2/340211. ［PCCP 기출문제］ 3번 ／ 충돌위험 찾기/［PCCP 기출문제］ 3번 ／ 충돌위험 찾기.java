import java.util.*;

class Solution {

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int robotCount = routes.length;
        List<List<Point>> paths = new ArrayList<>();

        // 1️⃣ 각 로봇의 전체 이동 경로 생성
        for (int i = 0; i < robotCount; i++) {
            List<Point> path = new ArrayList<>();

            int[] route = routes[i];
            int curR = points[route[0] - 1][0];
            int curC = points[route[0] - 1][1];

            path.add(new Point(curR, curC)); // 시작 위치

            for (int j = 1; j < route.length; j++) {
                int targetR = points[route[j] - 1][0];
                int targetC = points[route[j] - 1][1];

                // r 먼저 이동
                while (curR != targetR) {
                    curR += (targetR > curR) ? 1 : -1;
                    path.add(new Point(curR, curC));
                }

                // c 이동
                while (curC != targetC) {
                    curC += (targetC > curC) ? 1 : -1;
                    path.add(new Point(curR, curC));
                }
            }

            paths.add(path);
        }

        // 2️⃣ 시간 단위로 충돌 체크
        int maxTime = 0;
        for (List<Point> p : paths) {
            maxTime = Math.max(maxTime, p.size());
        }

        int danger = 0;

        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();

            for (List<Point> path : paths) {
                if (t >= path.size()) continue; // 이미 종료

                Point p = path.get(t);
                String key = p.r + "," + p.c;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (int cnt : map.values()) {
                if (cnt >= 2) danger++;
            }
        }

        return danger;
    }
}
