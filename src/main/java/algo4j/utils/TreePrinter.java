package algo4j.utils;

import algo4j.ds.BST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by aaron on 7/26/18.
 */
public class TreePrinter {
    public static String printRandomTree(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        ArrayUtil.shuffle(data);
        BST<Integer, Integer> tree = new BST<Integer, Integer>();
        for (Integer i : data) {
            tree.put(i, i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("digraph G {\n" +
                "  graph [ dpi = 150 ];\n" +
                "  nodesep=0.3;\n" +
                "  ranksep=0.2;\n" +
                "  margin=0.1;\n" +
                "  node [shape=circle];\n" +
                "  edge [arrowsize=0.8];\n");
        traverseTree(tree.getRoot(), stringBuffer);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private static <K extends Comparable, V> void traverseTree(BST.Node<K, V> node, StringBuffer stringBuffer) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            stringBuffer.append("  " + node.getKey() + " -> " + node.getLeft().getKey() + ";\n");
        }
        if (node.getRight() != null) {
            stringBuffer.append("  " + node.getKey() + " -> " + node.getRight().getKey() + ";\n");
        }
        traverseTree(node.getLeft(), stringBuffer);
        traverseTree(node.getRight(), stringBuffer);
    }

    public static void main(String[] args) throws IOException {
        String content = printRandomTree(50);
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/aaron/test.dot"));
        writer.write(content);
        writer.close();
    }
}
