class Solution {
    public String solution(String s) {
        String[] tokens = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        
        
        for (String token: tokens){
            System.out.print(token);
            int value = Integer.parseInt(token);
            
            max = Math.max(max,value);
            min = Math.min(min,value);
            System.out.print("max = "+max+"min = "+min);
            
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}