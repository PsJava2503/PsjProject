package com.psj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TermCoding {

    static List<String> res = new ArrayList<>();
    static final int SEG_COUNT = 4;

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new ArrayList<>());
        return res;
    }

    public static void dfs(String s, int count, int index, List<String> sb) {
        if (count == 3 && isValid(s.substring(index))) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sb.size(); i++) {
                temp.append(sb.get(i));
            }
            temp.append(s.substring(index));
            res.add(temp.toString());
        }

        for (int i = index + 1; i < s.length(); i++) {
            if (isValid(s.substring(index, i))) {
                StringBuilder temp = new StringBuilder();
                temp.append(s, index, i);
                temp.append(".");
                sb.add(temp.toString());
                count++;
                dfs(s, count, i, sb);
                count--;
                sb.remove(sb.size() - 1);
            }
        }
    }

    public static boolean isValid(String s){
        if (s.length() == 0) return false;
        char[] cs = s.toCharArray();
        if (cs[0] == '0' && cs.length != 1) return false;
        int res = 0;
        for (int i = 0; i < cs.length; i++){
            res = res * 10 + cs[i] - '0';
        }
        if (res >= 0 && res <= 255){
            return true;
        }
        return false;
    }
}
