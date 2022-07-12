//Given an integer array nums, return the largest perimeter of a triangle with 
//a non-zero area, formed from three of these lengths. If it is impossible to form 
//any triangle of a non-zero area, return 0. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,1,2]
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁶ 
// 
// Related Topics 贪心 数组 数学 排序 👍 197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
