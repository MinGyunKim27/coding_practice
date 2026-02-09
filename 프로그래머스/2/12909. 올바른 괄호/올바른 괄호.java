class Solution {
    boolean solution(String s) {
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            } else { // ')'
                openCount--;

                // 닫는 괄호가 더 많아지는 순간 바로 실패
                if (openCount < 0) {
                    return false;
                }
            }
        }

        // 열린 괄호가 남아있으면 실패
        return openCount == 0;
    }
}
