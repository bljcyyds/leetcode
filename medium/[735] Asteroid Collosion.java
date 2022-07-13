//We are given an array asteroids of integers representing asteroids in a row. 
//
// For each asteroid, the absolute value represents its size, and the sign 
//represents its direction (positive meaning right, negative meaning left). Each 
//asteroid moves at the same speed. 
//
// Find out the state of the asteroids after all collisions. If two asteroids 
//meet, the smaller one will explode. If both are the same size, both will explode. 
//Two asteroids moving in the same direction will never meet. 
//
// 
// Example 1: 
//
// 
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never 
//collide.
// 
//
// Example 2: 
//
// 
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
// 
//
// Example 3: 
//
// 
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide 
//resulting in 10.
// 
//
// 
// Constraints: 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 数组 👍 259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 栈中的数字表示当前的状态，栈顶的数字表示当前的状态
        Stack<Integer> stack = new Stack<>();
        // 存储结果
        for (int i = 0; i < asteroids.length; i++) {
            // 如果栈为空，直接入栈
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            }
            else {
                if (asteroids[i] > 0) {
                    // 如果是正数，直接入栈
                    stack.push(asteroids[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                        // 如果栈顶的数字大于0，且栈顶的数字小于等于当前的数字，则弹出栈顶的数字
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        // 如果栈为空，或者栈顶的数字小于0，则入栈
                        stack.push(asteroids[i]);
                    } else if (stack.peek() == -asteroids[i]) {
                        // 如果栈顶的数字等于当前的数字，则弹出栈顶的数字
                        stack.pop();
                    }
                }
            }
        }
        // 存储结果
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            // 反转栈，因为栈是先进后出的
            res[i] = stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
