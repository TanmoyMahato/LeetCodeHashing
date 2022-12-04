//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int nums[], int N, int target) {
        //HashMap<subarraySum, Index>  
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int subarraySum = 0;
        int maxLength = Integer.MIN_VALUE;
      //traverse the array
        for(int index=0; index<nums.length; index++){
            subarraySum += nums[index];
            
          //if(sum of subarray == target)  
            if(subarraySum == target){
                maxLength = index+1; //index+1 = length of current subarray
            }
            
          //if(sum of subarray > target)  
            int requiredSubarraySum = subarraySum - target; 
          //searching requiredSubarraySum in map means we expect --> (requiredSubarraySum == k) 
          //so we search requiredSubarraySum in map as it may have occurred earlier
            if(map.containsKey(requiredSubarraySum)){
              //we got requiredSubarraySum, so we compare the length with minLength
                //also (index-map.get(requiredSubarraySum)) is the length of requiredSubarraySum
                //because here (map.get(requiredSubarraySum)) is the length of previously occurred 
                //subarray having sum == target
                maxLength = Math.max(maxLength, index-map.get(requiredSubarraySum)); 
            }
            
          //put the sum of all the subarrays as KEY in map 
          //with their index as VALUE
            if(!map.containsKey(subarraySum))
                map.put(subarraySum, index);
        }
        
        if(maxLength == Integer.MIN_VALUE)
            return 0;
        
        return maxLength;
    }
    
    
}


