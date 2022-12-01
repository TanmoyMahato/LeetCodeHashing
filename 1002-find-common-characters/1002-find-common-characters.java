class Solution {
    public List<String> commonChars(String[] words) {
        
      //map to store char's of 1st word as KEY and their frequency as VALUE   
        HashMap<Character, Integer> parentMap = new HashMap<>();
        for(char ch: words[0].toCharArray()){
            parentMap.put(ch, parentMap.getOrDefault(ch,0)+1);
        }
        
      //traverse the words array to compare and check characters of other words  
        for(int index=1; index<words.length; index++){
            
          //store char's of word at index
            HashMap<Character,Integer> childMap = new HashMap<Character,Integer>();
            for(char ch: words[index].toCharArray()){
                childMap.put(ch, childMap.getOrDefault(ch,0)+1);
            }
            
          //check for char's present in both parent and child
            for(char KEY: parentMap.keySet()){
                if(childMap.containsKey(KEY))
                    parentMap.put(KEY, Math.min(childMap.get(KEY),parentMap.get(KEY)));
                else
                    parentMap.put(KEY,0);
            }
        }
        
      //add common characters to list
        ArrayList<String> list = new ArrayList<>();
        for(char KEY: parentMap.keySet()){
          //add char to the list equal to its frequency  
          //eg: if KEY:"l" has VALUE:2, add "l" 2times in list  
            while(parentMap.get(KEY)>0){
                list.add(String.valueOf(KEY));
                parentMap.put(KEY, parentMap.get(KEY)-1);
            }                
        }
        
        return list;
    }
}