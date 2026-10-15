class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();

        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }

        StringBuilder newStr = new StringBuilder();

       PriorityQueue<Character> pq = new PriorityQueue<>(
        (a,b)-> hmap.get(b) - hmap.get(a)
       );
       
       for(char c: hmap.keySet()){
        pq.add(c);
       }

       while(!pq.isEmpty()){
          char ch = pq.poll();
         int k = hmap.get(ch);
         for(int i=0; i<k; i++){
            newStr.append(ch);
         }
       }

        String str = newStr.toString();

        return str;
    
    }
}