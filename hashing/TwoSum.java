package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //brute force have TC of O(n^2) and SC of O(1)

    public static int[] twoSumBrute(int[] nums, int target){

        for(int i = 0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[] {i,j}; 
            }
        }
        return new int[]{};
    }

    // Overall TC of O(n) and Overall SC: O(n)
    public static int[] twoSumOptimised(int[] nums, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length;i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }


        return new int[]{};
    }

    public static void main(String[] args){

        int[] nums = {12,3,3,4,5,6,7};
        int target = 9;

        System.out.println(Arrays.toString(twoSumBrute(nums, target)));
        System.out.println(Arrays.toString(twoSumOptimised(nums, target)));

    }

}
