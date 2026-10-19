class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> listStr = new ArrayList<>();
         HashMap<String,ArrayList<String>> hmap = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String curr = strs[i];
            char[] charArray = curr.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(hmap.containsKey(sortedStr)){
                hmap.get(sortedStr).add(curr);
            }else{
                hmap.put(sortedStr,new ArrayList<String>());
                hmap.get(sortedStr).add(curr);
            }
        }

        for(String str : hmap.keySet()){
            listStr.add(hmap.get(str));
        }
        return listStr;
    }
}