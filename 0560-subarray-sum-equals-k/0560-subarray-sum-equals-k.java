class Solution {
    public int subarraySum(int[] nums, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        int count = 0;
        int subarraySum = 0;
        for(int index=0; index<nums.length; index++){
            subarraySum += nums[index];
            
            int removeSum = subarraySum - sum;
            
            if(map.containsKey(removeSum))
                count += map.get(removeSum);
            
            map.put(subarraySum, map.getOrDefault(subarraySum,0)+1);
        }
        
        return count;
    }
}