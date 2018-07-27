package algo4j.ds;


import java.util.*;

/**
 * Created by aaron on 7/19/18.
 */
public class BST<K extends Comparable, V> implements ST<K, V> {
    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        public Node() {}
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public V getValue() {
            return value;
        }
    }

    private Node<K, V> root = null;

    public Node<K, V> getRoot() {
        return root;
    }

    public void put(K key, V value) {
        root = put(key, value, root);
//        if (root == null) {
//            root = new Node<K, V>(key, value);
//            return;
//        }
//        put(key, value, root);
    }

//    private void put(K key, V value, Node<K, V> node) {
//        int cmp = key.compareTo(node.key);
//        if (cmp == 0) {
//            node.value = value;
//            return;
//        } else if (cmp > 0) {
//            if (node.right == null) {
//                node.right = new Node<K, V>(key, value);
//                return;
//            } else {
//                put(key, value, node.right);
//            }
//        } else {
//            if (node.left == null) {
//                node.left = new Node<K, V>(key, value);
//                return;
//            } else {
//                put(key, value, node.left);
//            }
//        }
//
//    }

    private Node<K, V> put(K key, V value, Node<K, V> node) {
        if (node == null) {
            return new Node<K, V>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
            return node;
        } else if (cmp > 0) {
            node.right = put(key, value, node.right);
        } else {
            node.left = put(key, value, node.left);
        }
        return node;
    }

    public V get(K key) {
        return get(key, root);
    }

    // recursie get
    private V get(K key, Node<K, V> node) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        else if (cmp > 0) {
            return get(key, node.right);
        } else {
            return get(key, node.left);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K,V> delete(Node<K, V> node, K key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node.right = delete(node.right, key);
        }
        else if (cmp > 0) {
            node.left = delete(node.left, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node<K,V> min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node<K,V> deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        int s = 0;
        for (K key : keys()) {
            s += 1;
        }
        return s;
    }

    public Iterable<K> keys() {
        java.util.List<K> nodes = new java.util.ArrayList<K>();
        keys(nodes, root);
        return nodes;
    }

    private void keys(java.util.List nodes, Node<K, V> node) {
        if (node == null) {
            return;
        }
        keys(nodes, node.left);
        nodes.add(node.key);
        keys(nodes, node.right);
    }
}
