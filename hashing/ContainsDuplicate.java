package hashing; 

// import java.util.HashSet;
// import java.util.Set; 

////brute force 
/// always use loops, nested loops for brute force solutions
/// 
class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        int size = nums.length;
        for (int i=0; i<size; i++){
            for (int j=i+1; j<size; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main( String[] args){

        // int[] nums = {1,2,3,4,1,2};
        int [] nums2 = {1,2,3,4};

        ContainsDuplicate cd = new ContainsDuplicate();
        //ContainsDuplicate is a 

        System.out.println(cd.hasDuplicate(nums2));
    }

}

// public class ContainsDuplicate {

//     public static boolean containsDuplicate(int[] nums){

//     Set<Integer> set = new HashSet<>();

//     for (int num : nums){
//         if( set.contains(num)){
//             return true;
//         }
//         set.add(num);
//     }
//     return false;

//     }
//     public static void main(String[] args){
//         int[] nums1 = {1,2,3,4};
//         int[] nums2 = {1,2,3,1};

//         System.out.println(containsDuplicate(nums1));
//         System.out.println(containsDuplicate(nums2));

//     }   
// }
