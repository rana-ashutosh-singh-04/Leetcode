class Solution {
    public String longestPrefix(String s) {
        int LPS[] = new int[s.length()];

        int prefix=0;
        int suffix=1;

        while(suffix<s.length()){
            if(s.charAt(prefix)==s.charAt(suffix)){
                LPS[suffix]=prefix+1;
                suffix++;
                prefix++;
            }else if(prefix==0){
                LPS[suffix]=0;
                suffix++;
            }else{
                prefix=LPS[prefix-1];
            }
        }
        return s.substring(0,LPS[s.length()-1]);
    }
}