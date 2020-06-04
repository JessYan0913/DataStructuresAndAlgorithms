package com.java.recursive;

public class ReverseArray {

    public void handle(char[] s) {
        if (s.length <= 0) return;
        reverse(0, s);
    }

    private void reverse(int index, char[] str) {
        //递归退出条件，当两个指针重合或相差为1时退出递归
        if (str == null || index >= str.length || index == (str.length - index - 1) || index - 1 == (str.length - index - 1)) {
            return;
        }
        reverse(index + 1, str);
        //两个指针元素异位
        char temp = str[index];
        str[index] = str[str.length - index - 1];
        str[str.length - index - 1] = temp;
    }

}
