class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removedZeros = 0;

        while (!s.equals("1")) {
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeros++;
            }
            removedZeros += zeros;

            int c = s.length() - zeros;          // 0 제거 후 남은(=1의 개수)
            s = Integer.toBinaryString(c);       // 길이를 2진 문자열로
            count++;
        }

        return new int[]{count, removedZeros};
    }
}