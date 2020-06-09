package com.java.recursive;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows < 0) {
            return new ArrayList<>();
        }

        List<Integer> oneLine = new ArrayList<>();
        oneLine.add(1);
        if (numRows == 0) {
            resultList.add(oneLine);
        }
        resultList.add(oneLine);

        List<Integer> twoLine = new ArrayList<>();
        twoLine.add(1);
        twoLine.add(1);
        if (numRows == 1) {
            resultList.add(twoLine);
        }
        resultList.add(twoLine);

        for (int i = 2; i < numRows + 1; i++) {
            resultList.add(generateLine(i, resultList.get(i - 1)));
        }
        return resultList;
    }

    public static List<Integer> generateLine(int now, List<Integer> lastLine) {
        List<Integer> resultLine = new ArrayList<>(now);
        resultLine.add(1);
        for (int i = 1; i < now; i++) {
            resultLine.add(lastLine.get(i) + lastLine.get(i - 1));
        }
        resultLine.add(1);
        return resultLine;
    }

    public static List<Integer> getRow(int rowIndex) {
        long[] ans = new long[rowIndex + 1];
        ans[0] = 1;
        int i;
        for (i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] * rowIndex-- / i;
        }
        List<Integer> list = new ArrayList<>();
        for (long l : ans) {
            list.add((int)l);
        }

        return list;
    }
}
