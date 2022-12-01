class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int index=0; index<s.length(); index++){
            map.put(s.charAt(index), map.getOrDefault(s.charAt(index),0)+1);
        }
        
        for(int index=0; index<s.length(); index++){
            if(map.get(s.charAt(index)) == 1)
                return index;
        }
        
        return -1;
    }
}