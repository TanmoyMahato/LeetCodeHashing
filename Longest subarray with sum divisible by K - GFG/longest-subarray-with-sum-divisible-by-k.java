//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int arr[], int n, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int subarraySum = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int index=0; index<arr.length; index++){
            subarraySum += arr[index];
            
            int subarrayRem = subarraySum % k;
            if(subarrayRem < 0){
                subarrayRem += k;
            }
            if(subarrayRem == 0){
                maxLength = index+1;
            }
            if(map.get(subarrayRem) != null){
                maxLength = Math.max(maxLength, index-map.get(subarrayRem));
            }
            if(map.get(subarrayRem) == null){
                map.put(subarrayRem, index);
            }
        }
        
        if(maxLength == Integer.MIN_VALUE)
            return 0; 
        
        return maxLength;
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends