class Solution {
    
    // 한번 접기
    public int[] divide(int[] bill){
        if (bill[0] > bill[1]){
            bill[0] = bill[0]/2;
        }
        else{
            bill[1] = bill[1]/2;
        }
        
        return bill;
    }
    
    // 지갑에 들어가는지 판별
    public boolean putInWallet(int[] wallet, int[] bill){
        int w_bigger,w_smaller,b_bigger,b_smaller;
        w_bigger = (wallet[0]>wallet[1]) ? wallet[0] : wallet[1];
        w_smaller = (wallet[0]<wallet[1]) ? wallet[0] : wallet[1];
        b_bigger = (bill[0]>bill[1]) ? bill[0] : bill[1];
        b_smaller = (bill[0]<bill[1]) ? bill[0] : bill[1];
        
        if(w_bigger>=b_bigger && w_smaller>=b_smaller){
            return true;
        }
        else
            return false;
    }
    
    // 절반으로 줄이기
    //  홀수이면 버려야 함
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean asIf = putInWallet(wallet,bill);
        while(!asIf){
            bill = divide(bill);
            asIf = putInWallet(wallet,bill);
            answer += 1;
        }
        return answer;
    }
}