import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름 → 현재 등수
        Map<String, Integer> rank = new HashMap<>();
        
        // 초기 등수 기록
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String name : callings) {
            int curRank = rank.get(name);   // 현재 등수
            int frontRank = curRank - 1;    // 앞 선수 등수
            
            // 앞 선수 이름
            String frontPlayer = players[frontRank];
            
            // 1) players 배열 swap
            players[frontRank] = name;
            players[curRank] = frontPlayer;
            
            // 2) map 등수 정보 swap
            rank.put(name, frontRank);
            rank.put(frontPlayer, curRank);
        }

        return players;
    }
}
