package th.ac.kmutt.cpe.algorithm.wisit.lab.lab9;

import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '\0';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanCoding {
    private Node root;
    private Map<Character, String> codeMap = new HashMap<>();

    public void buildTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (var e : freqMap.entrySet())
            pq.add(new Node(e.getKey(), e.getValue()));

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            pq.add(new Node(a.freq + b.freq, a, b));
        }
        root = pq.poll();
        buildCode(root, "");
    }

    private void buildCode(Node node, String code) {
        if (node.isLeaf()) {
            codeMap.put(node.ch, code);
            return;
        }
        buildCode(node.left, code + "0");
        buildCode(node.right, code + "1");
    }

    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(codeMap.get(c));
        }
        return sb.toString();
    }

    public String decode(String encoded) {
        StringBuilder res = new StringBuilder();
        Node curr = root;
        for (char bit : encoded.toCharArray()) {
            curr = (bit == '0') ? curr.left : curr.right;
            if (curr.isLeaf()) {
                res.append(curr.ch);
                curr = root;
            }
        }
        return res.toString();
    }

    public void printCodes() {
        System.out.println("\nHuffman Code results:");
        for (var e : codeMap.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HuffmanCoding huffman = new HuffmanCoding();
        System.out.print("Enter a string: ");
        String text = sc.nextLine().trim();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        huffman.buildTree(freqMap);
        huffman.printCodes();

        String encoded = huffman.encode(text);
        System.out.println("\nEncoded string: " + encoded);
        String decoded = huffman.decode(encoded);
        System.out.println("Decoded string: " + decoded);
        sc.close();
    }
}