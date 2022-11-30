//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        //create HashSet to store unique value
        HashSet<Integer> set = new HashSet<>();
        
        //Traverse the array
        for(int elmnt: arr){
            int temp = x-elmnt;
            //if(temp element is there in set) we got the pair, return true
            if(set.contains(temp)){
                return true;
            }
            //if(temp is not there in set) store the elmnt
            //so that we temp if any X-elmnt == temp
            set.add(elmnt);
        }
        
        //we traversed the array and got no pair equal to X
        return false;
    }
}