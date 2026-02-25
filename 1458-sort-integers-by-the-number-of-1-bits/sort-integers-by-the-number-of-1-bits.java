import java.util.*;
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nu=new Integer[arr.length];       
        for(int i=0;i< arr.length;i++){
            nu[i]=arr[i];
        }      
        Arrays.sort(nu,(a,b)->{
            int biA=Integer.bitCount(a);
            int biB=Integer.bitCount(b);           
            if(biA==biB)
                return a-b;
            else
                return biA-biB;
        });       
        for(int i=0;i<arr.length;i++){
            arr[i]=nu[i];
        }       
        return arr;
    }
}