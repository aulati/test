package cn.aulati.test.algorithm;

import java.security.InvalidParameterException;

public class Interview {
    /**
     *
     * @return
     */
    public static int solve(String s) {
        Node ret = helper(s, s.length(), 0);
        return ret.val;
    }

    private static Node helper(String s, int len, int i) {
        Node ret = new Node();
        ret.val = 0;

        loop:
        while (i < len) {
            Node node = Interview.getNext(s, len, i);

            switch (node.type) {
                case Number:
                    // number
                    ret.val += node.val;
                    i = node.end;
                    break;
                case Addition:
                case Subtraction:
                    // +/-
                    Node b = Interview.getNext(s, len, node.end);
                    if (b.type == NodeType.Number) {
                        // number
                        ret.val += process(node.val, b.val, node.type);
                    } else if (b.type == NodeType.LeftParenthesis) {
                        // (
                        b = helper(s, len, b.end);
                        ret.val += process(node.val, b.val, node.type);
                    }

                    i = b.end;
                    break;
                case LeftParenthesis:
                    // (
                    Node c = helper(s, len, node.end);
                    ret.val += process(node.val, c.val, node.type);
                    i = c.end;
                    break;
                case RightParenthesis:
                    // )
                    ret.end = node.end;
                    break loop;
            }
        }

        return ret;
    }

    private static int process(int a, int b, NodeType op) {
        int ret = 0;

        switch (op) {
            case Addition:
                ret = a + b;
                break;
            case Subtraction:
                ret = a - b;
                break;
        }

        return ret;
    }

    private static Node getNext(String s, int len, int i) {
        Node res = new Node();

        char c = s.charAt(i);
        if (c == '+') {
            res.type = NodeType.Addition;
            res.start = i;
            res.end = i + 1;
        } else if (c == '-') {
            res.type = NodeType.Subtraction;
            res.start = i;
            res.end = i + 1;
        } else if (c == '(') {
            res.type = NodeType.LeftParenthesis;
            res.start = i;
            res.end = i + 1;
        } else if (c == ')') {
            res.type = NodeType.RightParenthesis;
            res.start = i;
            res.end = i + 1;
        } else if ('0' <= c && c <= '9') {
            res.type = NodeType.Number;

            int j = i + 1;
            while (j < len) {
                c = s.charAt(j);
                if ('0' <= c && c <= '9') {
                    j++;
                } else {
                    break;
                }
            }

            res.val = Integer.parseInt(s.substring(i, j));
            res.start = i;
            res.end = j;

        } else {
            throw new InvalidParameterException("The format is incorrect!");
        }

        return res;
    }

    static class Node {
        /**
         * 0: number,
         * 1: +
         * 2: -
         * 3: (
         * 4: )
         */
        NodeType type;

        /** value */
        int val;

        /** start index */
        int start;

        /** end index */
        int end;
    }

    static enum NodeType {
        Number,
        Addition,
        Subtraction,
        LeftParenthesis,
        RightParenthesis
    }
}
