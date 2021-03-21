package com.arthur.leetcodeWeeklyContest.No233Week;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/3/21 10:31
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        new No1().maxAscendingSum(new int[]{10,20,30,5,10,50});
    }

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                max += nums[i];
            }
            else {

                max = nums[i];
            }
            ans = Math.max(ans, max);
        }
        return ans;

    }
}
/*

5709. 最大升序子数组和 显示英文描述
        通过的用户数0
        尝试过的用户数2
        用户总通过次数0
        用户总提交次数2
        题目难度Easy
        给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。

        子数组是数组中的一个连续数字序列。

        已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。



        示例 1：

        输入：nums = [10,20,30,5,10,50]
        输出：65
        解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
        示例 2：

        输入：nums = [10,20,30,40,50]
        输出：150
        解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
        示例 3：

        输入：nums = [12,17,15,13,10,11,12]
        输出：33
        解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
        示例 4：

        输入：nums = [100,10,1]
        输出：100


        提示：

        1 <= nums.length <= 100
        1 <= nums[i] <= 100
*/
