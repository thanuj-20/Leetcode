class Solution {
    public int numSteps(String s) {
        int stp=0;
        int cay=0;
        for(int i=s.length()-1;i>0;i--){
            int bt=s.charAt(i)-'0';            
            if (bt+cay==1){
                stp+=2;
                cay=1;
            } else {
                stp+=1;
            }
        }
        return stp+cay;
    }
}