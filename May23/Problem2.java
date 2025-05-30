//Given an array of integers and a target sum k, return the total number of continuous subarrays whose sum equals to k.

import java.util.*;

public class Problem2 {
   public int subArray(int[] arr, int target ){
    int size = arr.length;
    int count = 0;
    for(int i = 0; i<size; i++){
        int sum = 0;
        for(int j = i; j < size ; j++){
                sum += arr[j];
                if(sum == target){
                  count++;
            }   
        }
    }
    return count;
   }
   public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    Problem2 obj = new Problem2();
    int result = obj.subArray(arr, target);
    System.out.println(result);
    sc.close(); 
  }
    
}
