class Solution {
    public int myAtoi(String s) {        
        int i=0,n=s.length();
        int si=1;
        long numm=0;
        while(i<n&&s.charAt(i)==' ')
            i++;
        if(i<n&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
            if(s.charAt(i)=='-') si=-1;
            i++;
        }
        while(i<n&&Character.isDigit(s.charAt(i))){
            numm=numm*10+(s.charAt(i)-'0');
            if(si*numm>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(si*numm<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;            
            i++;
        }        
        return (int)(si*numm);
    }
}