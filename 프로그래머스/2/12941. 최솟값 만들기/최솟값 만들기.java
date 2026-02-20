import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); // 오름차순

        // B는 내림차순 정렬이 필요하므로 Integer로 변환
        Integer[] bArr = new Integer[B.length];
        for (int i = 0; i < B.length; i++) bArr[i] = B[i];

        Arrays.sort(bArr, Collections.reverseOrder()); // 내림차순

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * bArr[i];
        }
        return sum;
    }
}
