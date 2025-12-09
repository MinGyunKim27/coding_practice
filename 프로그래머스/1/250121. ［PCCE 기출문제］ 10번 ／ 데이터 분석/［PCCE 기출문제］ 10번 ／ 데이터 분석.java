import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);

        return Arrays.stream(data)
                // 1) 필터링: ext 열의 값이 val_ext 보다 작은 행만 통과
                .filter(row -> row[extIdx] < val_ext)
                // 2) 정렬: sort_by 열 기준 오름차순
                .sorted(Comparator.comparingInt(row -> row[sortIdx]))
                // 3) 다시 2차원 배열로 변환
                .toArray(int[][]::new);
    }

    private int getIndex(String key) {
        switch (key) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                throw new IllegalArgumentException("unknown key: " + key);
        }
    }
}
