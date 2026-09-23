class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minDiff = arr[1]-arr[0];

        for(int i=arr.length-1; i>0; i--){
            int diff = arr[i]-arr[i-1];
            minDiff= Math.min(diff,minDiff);
        }

        List<List<Integer>> arrList= new ArrayList<>();
         
         for(int i = 1; i < arr.length; i++){
            int diff = arr[i]-arr[i-1];
            if(diff==minDiff){
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(arr[i-1]);
                aList.add(arr[i]);
                arrList.add(aList);
            }
         }


         return arrList;
    }
}