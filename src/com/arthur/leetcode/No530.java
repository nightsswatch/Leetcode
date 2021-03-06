package com.arthur.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @title: No530
 * @Author ArthurJi
 * @Date: 2021/3/6 9:46
 * @Version 1.0
 */
public class No530 {
    public static void main(String[] args) {
        new No530().nextGreaterElements(new int[] {1, 2, 1});
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return ans;
    }
}

/*503. 下一个更大元素 II
        给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

        示例 1:

        输入: [1,2,1]
        输出: [2,-1,2]
        解释: 第一个 1 的下一个更大的数是 2；
        数字 2 找不到下一个更大的数；
        第二个 1 的下一个最大的数需要循环搜索，结果也是 2。*/
/*方法一：单调栈 + 循环数组
        思路及算法

        我们可以使用单调栈解决本题。单调栈中保存的是下标，从栈底到栈顶的下标在数组 \textit{nums}nums 中对应的值是单调不升的。

        每次我们移动到数组中的一个新的位置 ii，我们就将当前单调栈中所有对应值小于 \textit{nums}[i]nums[i] 的下标弹出单调栈，这些值的下一个更大元素即为 \textit{nums}[i]nums[i]（证明很简单：如果有更靠前的更大元素，那么这些位置将被提前弹出栈）。随后我们将位置 ii 入栈。

        但是注意到只遍历一次序列是不够的，例如序列 [2,3,1][2,3,1]，最后单调栈中将剩余 [3,1][3,1]，其中元素 [1][1] 的下一个更大元素还是不知道的。

        一个朴素的思想是，我们可以把这个循环数组「拉直」，即复制该序列的前 n-1n−1 个元素拼接在原序列的后面。这样我们就可以将这个新序列当作普通序列，用上文的方法来处理。

        而在本题中，我们不需要显性地将该循环数组「拉直」，而只需要在处理时对下标取模即可。

        代码

        C++JavaJavaScriptPython3GolangC

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/next-greater-element-ii/solution/xia-yi-ge-geng-da-yuan-su-ii-by-leetcode-bwam/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
