import java.util.*;
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> ab=new ArrayList<>();
        for(int x:nums)ab.add(x);
        int op=0;
        while(!isSorted(ab)){
            int minum=Integer.MAX_VALUE;
            int idxx=0;
            for(int i=0;i<ab.size()-1;i++){
                int s=ab.get(i)+ab.get(i+1);
                if(s<minum){
                    minum=s;
                    idxx=i;
                }
            }
            ab.set(idxx,minum);
            ab.remove(idxx+1);
            op++;
        }
        return op;
    }
    private boolean isSorted(List<Integer> ab){
        for(int i=1;i<ab.size();i++){
            if (ab.get(i)<ab.get(i-1)) return false;
        }
        return true;
    }
}
