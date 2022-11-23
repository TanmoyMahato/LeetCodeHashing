//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
        int t = Integer.parseInt(br.readLine().trim()); 
        while(t-->0){
            
            //size of array
            int N = Integer.parseInt(br.readLine().trim()); 
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i = 0 ; i < N; i++){
                arr[i]=Integer.parseInt(inputLine[i]); 
            }
            int P= Integer.parseInt(br.readLine().trim());
            //calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P); 
            
            //printing array elements
            for(int i = 0; i < N ; i++)
                System.out.print(arr[i] + " " );
            System.out.println();
        }
    }
}




// } Driver Code Ends


class Solution{
    //Function to count the frequency 
    //of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        //create hashmap to store frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //iterate the array elements
        //store element as KEY
        //store their frequency as VALUE
        for(int index=0; index<arr.length; index++){
            if(map.containsKey(arr[index])){
                map.put(arr[index], map.get(arr[index])+1);
            }
            else{
                map.put(arr[index], 1);
            }
        }
        
        //traverse from 1 to N, store 0 if map doesn't has key
        //store value if the map has key
        int key=1;
        for(int i=0; i<N; i++){
            if(map.containsKey(i+1))
               arr[i] = map.get(i+1);
            else{
               arr[i] = 0;
               key++;
            }
        }
    }
}
