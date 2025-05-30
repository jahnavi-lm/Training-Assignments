//Given a sorted array of integers, return the indices of the two numbers such that they add up to a specific target.

import java.util.*;

class Problem1{ 
    public int[] sumoftwo(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] { left, right }; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {}; 
    } 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter values of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter target value");
        int target = sc.nextInt();
        Problem1 obj = new Problem1();
        int[] result = obj.sumoftwo(arr, target);
        System.out.println(Arrays.toString(result));
        sc.close(); 
    }

}