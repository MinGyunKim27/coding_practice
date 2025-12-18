import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 문자별 최소 입력 횟수 저장 (A~Z)
        int[] minPress = new int[26];
        Arrays.fill(minPress, Integer.MAX_VALUE);

        // keymap 전처리
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int idx = c - 'A';
                minPress[idx] = Math.min(minPress[idx], i + 1);
            }
        }

        // targets 계산
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            boolean possible = true;

            for (char c : target.toCharArray()) {
                int idx = c - 'A';
                if (minPress[idx] == Integer.MAX_VALUE) {
                    possible = false;
                    break;
                }
                total += minPress[idx];
            }

            answer[i] = possible ? total : -1;
        }

        return answer;
    }
}
