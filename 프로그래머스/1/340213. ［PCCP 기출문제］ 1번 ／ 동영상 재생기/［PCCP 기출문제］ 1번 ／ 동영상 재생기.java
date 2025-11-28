class Solution {

    private int toSeconds(String time) {
        int mm = Integer.parseInt(time.substring(0, 2));
        int ss = Integer.parseInt(time.substring(3, 5));
        return mm * 60 + ss;
    }

    private String toTimeString(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    private int skipOpening(int cur, int opStart, int opEnd) {
        if (cur >= opStart && cur <= opEnd) {
            return opEnd;
        }
        return cur;
    }

    public String solution(String video_len, String pos, 
                           String op_start, String op_end, 
                           String[] commands) {

        int videoLenSec = toSeconds(video_len);
        int cur = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        cur = skipOpening(cur, opStart, opEnd);

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur -= 10;
                if (cur < 0) cur = 0;
            } else if (cmd.equals("next")) {
                cur += 10;
                if (cur > videoLenSec) cur = videoLenSec;
            }
            
            cur = skipOpening(cur, opStart, opEnd);
        }

        return toTimeString(cur);
    }
}
