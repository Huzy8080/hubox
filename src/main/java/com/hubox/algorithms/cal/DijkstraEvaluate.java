package com.hubox.algorithms.cal;

import com.hubox.util.Stack;
import com.hubox.util.stdlib.StdOut;

import java.util.Arrays;
import java.util.List;

/**
 * Dijkstra 双栈算术表达式求值算法
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/31 21:06
 */
public class DijkstraEvaluate {
    private static final List<String> op = Arrays.asList("+", "-", "*", "/", "sqrt");

    //expressions 是未省略括号的算术表达式 如： ( 1 + ( 2 * 3 ) )
    //每个元素作为数组中的一个值
    public static Double evaluate(String[] expressions) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String e : expressions) {
            if ("(".equals(e)) ;
            else if (op.contains(e)) ops.push(e);
            else if (")".equals(e)) {
                String curOp = ops.pop();
                Double curVal = vals.pop();
                if ("+".equals(curOp)) curVal = vals.pop() + curVal;
                if ("-".equals(curOp)) curVal = vals.pop() - curVal;
                if ("*".equals(curOp)) curVal = vals.pop() * curVal;
                if ("/".equals(curOp)) curVal = vals.pop() / curVal;
                if ("sqrt".equals(curOp)) curVal = Math.sqrt(curVal);
                vals.push(curVal);
            } else {
                vals.push(Double.parseDouble(e));
            }
        }
        return vals.pop();
    }

    //无括号，使用优先级来做
    // 1 + ( 1 + 2 ) * ( 2 * 3 + 4 / 2 - 5 ) * ( 1 + 1 ) + 1 怎么实现？
    public static Double evaluateP(String[] s) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        boolean cal = true;//是否能继续向前取值进行计算
        for (int i = 0; i < s.length; i++) {
            String st = s[i];
            String next = i == s.length - 1 ? null : s[i + 1];
            if ("(".equals(s[i])) {
                ops.push(st);
            } else if ("+".equals(st) || "-".equals(st)) {
                ops.push(st);
            } else if ("*".equals(st) || "/".equals(st)) {
                if ("(".equals(next)) {//延迟计算
                    ops.push(st);
                } else {//立即计算
                    if (next == null) throw new IllegalArgumentException("expression is illegal!");
                    if ("*".equals(st)) {
                        vals.push(vals.pop() * Double.parseDouble(next));
                    } else {
                        vals.push(vals.pop() / Double.parseDouble(next));
                    }
                    i++;
                }
            } else if (")".equals(st)) {//遇到右括号，将括号内的算尽，且把前面高优先级的符号计算掉
                cal = true;
                do {
                    String curOp = ops.pop();
                    if ("(".equals(curOp)) {
                        cal = false;
                        continue;
                    }
                    Double sufVal = vals.pop();
                    Double preVal = vals.pop();
                    if ("+".equals(curOp)) vals.push(preVal + sufVal);
                    if ("-".equals(curOp)) vals.push(preVal - sufVal);
                    if ("*".equals(curOp)) vals.push(preVal * sufVal);
                    if ("/".equals(curOp)) vals.push(preVal / sufVal);
                } while (cal || (!ops.isEmpty() && ("*".equals(ops.peek()) || "/".equals(ops.peek()))));
            } else {
                vals.push(Double.parseDouble(st));
            }
        }
        while (!ops.isEmpty()) {
            String curOp = ops.pop();
            Double sufVal = vals.pop();
            Double preVal = vals.pop();
            if ("+".equals(curOp)) vals.push(preVal + sufVal);
            if ("-".equals(curOp)) vals.push(preVal - sufVal);
        }
        return vals.pop();
    }


    public static void main(String[] args) {
        Double aDouble = evaluateP("1 + 2 * 3".split(" "));
        StdOut.println(aDouble);
        StdOut.println(evaluateP("( ( 1 + ( ( 1 + 2 ) * ( 2 * 3 + 4 / 2 - 5 ) ) * ( 1 + 1 ) ) + 1 )".split(" ")));
        StdOut.println(evaluateP("1 + ( 1 + 2 ) * ( 2 * 3 + 4 / 2 - 5 ) * ( 1 + 1 ) + 1".split(" ")));
        assert 7 == evaluate("( 1 + ( 2 * 3 ) )".split(" "));
        assert 2.5 == evaluate("( 1 + sqrt ( 3 * 3 ) / 2.0 )".split(" "));
    }

    class Op {
        private int level;//优先级
        private String opStr;


    }


}
