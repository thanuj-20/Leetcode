class Solution {
    public String reverseWords(String s) {
        String[] words5=s.trim().split("\\s+");
        StringBuilder res5=new StringBuilder();
        for(int i=words5.length-1;i>=0;i--){
            res5.append(words5[i]);
            if(i!=0)
                res5.append(" ");
        }
        return res5.toString();
    }
}