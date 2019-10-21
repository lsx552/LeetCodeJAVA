package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinations_17 {
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private static ArrayList<String> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(letterCombinations(str));
        }

    }
    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        findCombination(digits, 0, "");
        return res;
    }

    public static void findCombination(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }
        return;
    }
}
