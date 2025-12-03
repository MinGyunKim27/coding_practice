import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 이름 -> 인덱스 매핑
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        // i가 j에게 준 선물 개수
        int[][] give = new int[n][n];
        // 각자 준/받은 총 개수
        int[] given = new int[n];
        int[] received = new int[n];

        // 선물 기록 처리
        for (String record : gifts) {
            String[] parts = record.split(" ");
            String from = parts[0];
            String to = parts[1];

            int a = idxMap.get(from);
            int b = idxMap.get(to);

            give[a][b] += 1;
            given[a] += 1;
            received[b] += 1;
        }

        // 선물 지수: 준 선물 - 받은 선물
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = given[i] - received[i];
        }

        // 다음 달에 받는 선물 개수 카운트
        int[] nextReceive = new int[n];

        // 모든 사람 쌍에 대해 규칙 적용
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int gij = give[i][j]; // i -> j
                int gji = give[j][i]; // j -> i

                if (gij > gji) {
                    // i가 더 많이 줬으니, 다음 달에 i가 1개 받음
                    nextReceive[i]++;
                } else if (gij < gji) {
                    // j가 더 많이 줬으니, 다음 달에 j가 1개 받음
                    nextReceive[j]++;
                } else {
                    // 주고받은 수가 같거나 둘 다 0 → 선물 지수 비교
                    if (giftIndex[i] > giftIndex[j]) {
                        nextReceive[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextReceive[j]++;
                    }
                    // 선물 지수도 같다면 아무 일도 안 일어남
                }
            }
        }

        // 가장 많이 받는 친구의 개수
        int answer = 0;
        for (int cnt : nextReceive) {
            if (cnt > answer) answer = cnt;
        }

        return answer;
    }
}
