class Solution {
    public String minWindow(String s, String t) {
        

        int arr[] = new int[256];

        for(char ch: t.toCharArray()){
            arr[ch]++;
        }

        int windowStart=0;
        int windowEnd=0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int require = t.length();
        int n = s.length();
        while(windowEnd<n){

            // Expansion phase
            char ch = s.charAt(windowEnd);

             arr[ch]--;

            if(arr[ch]>=0){
                require--;
            }

            // Shrinking phase

            while(require==0){

                ch = s.charAt(windowStart);
                
                int length = windowEnd-windowStart+1;
                if(length<minLength){
                    minLength=length;
                    startIndex = windowStart;
                }

                arr[ch]++;

                if(arr[ch]>0){
                    require++;
                }
                windowStart++;
            }

            windowEnd++;
        }

        if(startIndex==-1){
            return "";
        }else{
            return s.substring(startIndex,startIndex+minLength);
        }

    }
}