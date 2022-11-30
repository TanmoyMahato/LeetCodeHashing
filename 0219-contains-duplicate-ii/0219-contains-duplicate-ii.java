class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      //store array element as KEY and its index as VALUE  
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
      //traverse the array  
        for (int i = 0; i < nums.length; i++) {
          //if element is present in map, 
          //subtract its index present in map with current index  
            if (map.containsKey(nums[i])) {
              //if diference is <= k, it contains duplicate  
                if (i - map.get(nums[i]) <= k) return true;
            }
          //if(element is not there in map), insert it in map
            map.put(nums[i], i);
        }
        return false;
    }
}