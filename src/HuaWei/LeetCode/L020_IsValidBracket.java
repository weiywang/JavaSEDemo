package HuaWei.LeetCode;

import java.util.*;

public class L020_IsValidBracket {
    private Map<Character, Character> map = new HashMap<Character, Character>()
    {{put('{','}'); put('[',']'); put('(', ')');}};

    public boolean isValid(String s) {
        if(s.length()>0 && !map.containsKey(s.charAt(0))) return false;

        LinkedList<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
                //如果当前检测到输入为闭或其他字符，而当前栈已空，则返回false
            else if(stack.isEmpty() || map.get(stack.removeLast()) != c) return false;
        }

        return stack.isEmpty();
    }
}
