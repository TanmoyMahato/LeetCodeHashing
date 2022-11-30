//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        //create hashmap to store elements of a1[]
        HashMap<Long, Integer> map = new HashMap<>();
        
        //traverse a1[] and store its elements as KEY
        //and their frequency as VALUE
        for(int index=0; index<a1.length; index++){
            map.put(a1[index], map.getOrDefault(a1[index],0)+1);
        }
        
        
        //traverse a2[] for each element
        for(int index=0; index<a2.length; index++){
            //if element is present in map, reduce its frequency by 1
            if(map.containsKey(a2[index])){
                map.put(a1[index], map.get(a1[index])-1);
                //if frequency of element becomes 0, remove it from map
                if(map.get(a2[index]) <= 0){
                    map.remove(a2[index]);
                }
            }
            //if element not present in map, return "No"
            else{
                return "No";
            }
        }
        return"Yes";
    }
}