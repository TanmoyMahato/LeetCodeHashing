class Solution {
    public int[] twoSum(int[] nums, int target) {
      //create HashMap to store nums element as KEY and its index as VALUE
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int output[] = new int[]{-1,-1};
      //traverse the array  
        for(int index=0; index<nums.length; index++){
          //get difference of target with each element present in nums
            int temp = target-nums[index];
          //if(difference is present in map)  
            if(map.containsKey(temp)){                
                output[0] = map.get(temp);
                output[1] = index;
                return output;
            }
          //if(temp is not there in map) 
          //insert nums[index] as KEY and its index as VALUE
          //so we get temp if any target-nums[index] == temp
            map.put(nums[index], index);
        }
        
        return output;
    }
}