class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int ans_l=0;
        int ans_r=0;
        int l;
        int r;
        String x="";
        int maxl=1;
        // for odd palindrome string
        for(int i=1;i<n;i++){
            l=i-1;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>=maxl){
                    ans_l=l;
                    ans_r=r;
                    maxl=r-l+1;
                    

                }
                l--;
                r++;
                
            }



            
        }
        //for even palindrome 
        for(int i=0;i<n;i++){
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>=maxl){
                    ans_l=l;
                    ans_r=r;
                    maxl=r-l+1;
                }
                l--;
                r++;

            }
        }
        return s.substring(ans_l,ans_r+1);
        
        
        
                
    }
}