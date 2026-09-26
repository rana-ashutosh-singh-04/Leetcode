class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s.trim());
        sb = sb.reverse();
        int n = sb.length();
        StringBuilder words = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<n; i++){
            
            while(i<n && sb.charAt(i)!=' '){
               words.append(sb.charAt(i));
               i++;
            }

            if(words.length()>0){
                ans.append(words.reverse());
                ans.append(" ");
                words.setLength(0);
            }
        }
        return ans.toString().trim();
    }
}