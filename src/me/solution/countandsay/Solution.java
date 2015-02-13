package me.solution.countandsay;


/**
 * 当前测试结果:
 * 18 / 18 test cases passed.
 * Status: Accepted
 * Runtime: 177 ms
 * 
 * @see https://oj.leetcode.com/problems/count-and-say/
 * @author Song
 *
 */
public class Solution {

    /*
     * 1
     * 11
     * 21
     * 1211
     * 111221
     * 312211
     * 13112221
     * 1113213211
     * 31131211131221
     */
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = genNext(result);
        }
        return result;
    }

    private String genNext(String src) {
        StringBuilder result = new StringBuilder();
        int length = src.length();
        char[] array = src.toCharArray();
        char last = array[0];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (last == array[i]) {
                count++;
            } else {
                if (count > 0) {
                    result.append(count).append(last);
                    last = array[i];
                    count = 1;
                }
            }
            last = array[i];
        }
        result.append(count).append(last);
        return result.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //for (int i = 1; i < 50; i++)
        String countAndSay = new Solution().countAndSay(30);
        System.out.println(countAndSay.length());
        System.out.println("time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
