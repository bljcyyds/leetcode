//Given a string paragraph and a string array of the banned words banned, 
//return the most frequent word that is not banned. It is guaranteed there is at least 
//one word that is not banned, and that the answer is unique. 
//
// The words in paragraph are case-insensitive and the answer should be 
//returned in lowercase. 
//
// 
// Example 1: 
//
// 
//Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", 
//banned = ["hit"]
//Output: "ball"
//Explanation: 
//"hit" occurs 3 times, but it is a banned word.
//"ball" occurs twice (and no other word does), so it is the most frequent non-
//banned word in the paragraph. 
//Note that words in the paragraph are not case sensitive,
//that punctuation is ignored (even if adjacent to words, such as "ball,"), 
//and that "hit" isn't the answer even though it occurs more because it is 
//banned.
// 
//
// Example 2: 
//
// 
//Input: paragraph = "a.", banned = []
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= paragraph.length <= 1000 
// paragraph consists of English letters, space ' ', or one of the symbols: "!?
//',;.". 
// 0 <= banned.length <= 100 
// 1 <= banned[i].length <= 10 
// banned[i] consists of only lowercase English letters. 
// 
// Related Topics 哈希表 字符串 计数 👍 189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (Arrays.asList(banned).contains(word)) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int max = 0;
        String res = "";
        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
