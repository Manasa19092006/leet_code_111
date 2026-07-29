import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                count.push(num);
                result.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int times = count.pop();
                StringBuilder prev = result.pop();
                while (times-- > 0)
                    prev.append(curr);
                curr = prev;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}