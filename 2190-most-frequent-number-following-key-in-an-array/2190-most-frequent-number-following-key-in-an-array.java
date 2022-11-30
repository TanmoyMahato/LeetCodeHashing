class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int index=0; index<nums.length-1; index++){
            if(nums[index] == key)
                map.put(nums[index+1], map.getOrDefault(nums[index+1],0)+1);
        }
        
        int freqElmnt = 0;
        int max = 0;
        for(Integer k: map.keySet()){
            if(map.get(k) > max){
                max = map.get(k);
                freqElmnt = k;
            }
        }
        
        return freqElmnt;
    }
}