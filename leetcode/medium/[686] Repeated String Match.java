//Given two strings a and b, return the minimum number of times you should 
//repeat string a so that string b is a substring of it. If it is impossible for b to 
//be a substring of a after repeating it, return -1. 
//
// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and 
//repeated 2 times is "abcabc". 
//
// 
// Example 1: 
//
// 
//Input: a = "abcd", b = "cdabcdab"
//Output: 3
//Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b 
//is a substring of it.
// 
//
// Example 2: 
//
// 
//Input: a = "a", b = "aa"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist of lowercase English letters. 
// 
// Related Topics 字符串 字符串匹配 👍 279 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int m = a.length(), n = b.length();

        //检查b是否有a没有的字符，如果有不同字符则无法构成子串，直接返回-1
        int[] cnt = new int[26];
        for(char c : a.toCharArray()) cnt[c-'a']++;
        for(char c : b.toCharArray()){
            if(cnt[c-'a'] == 0) return -1;
        }

        //字符串a的三种叠加次数情况分别构成a的叠加字符串，再判断是否包含字符串b
        int len1 =n/m, len2 = n/m+1, len3 = n/m+2;
        String s1 = "", s2 = "", s3 = "";
        for(int i = 0; i < len1; ++i) s1 += a;
        for(int i = 0; i < len2; ++i) s2 += a;
        for(int i = 0; i < len3; ++i) s3 += a;
        if(s1.equals(b) || s1.contains(b)) return len1;
        if(s2.equals(b) || s2.contains(b)) return len2;
        if(s3.equals(b) || s3.contains(b)) return len3;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
