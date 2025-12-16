class Solution {
    public int[] solution(String[] wallpaper) {
        int H = wallpaper.length;
        int W = wallpaper[0].length();

        int minRow = H, minCol = W;
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // 드래그는 격자점 기준이므로 +1
        return new int[] {
            minRow,
            minCol,
            maxRow + 1,
            maxCol + 1
        };
    }
}
