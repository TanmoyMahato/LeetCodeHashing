// JAVA Code For Minimum operation to make
// all elements equal in array
import java.util.*;
 
class GFG {
     
    // function for min operation
    public static int minOperation (int arr[], int n)
    {
        // Insert all elements in hash.
       HashMap<Integer, Integer> hash = new HashMap<Integer,
                                           Integer>();
         
        for (int i=0; i<n; i++)
            if(hash.containsKey(arr[i]))
                hash.put(arr[i], hash.get(arr[i])+1);
            else hash.put(arr[i], 1);
         
        // find the max frequency
        int max_count = 0;
        Set<Integer> s = hash.keySet();
         
        for (int i : s)
            if (max_count < hash.get(i))
                max_count = hash.get(i);
      
        // return result
        return (n - max_count);
    }
     
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {1, 5, 2, 1, 3, 2, 1};
        int n = arr.length;
        System.out.print(minOperation(arr, n));
             
    }
}
