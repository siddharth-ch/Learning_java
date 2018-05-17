package datastructures;
import java.util.Arrays;
import java.util.Scanner;

public class TrieSample {
    static Trie t = new Trie();
    private static int[] count;

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int s = 0;
	count = new int[n];
	for (int a0 = 0; a0 < n; a0++) {
	    String op = in.next();
	    String contact = in.next();
	    if ("add".equalsIgnoreCase(op)) {
		add(contact);
	    } else {
		count[s++] = search(contact);
	    }
	}
	for (int j = 0; j < s; j++) {
	    System.out.println(count[j]);
	}
    }

    private static int search(String str) {
	TrieNode temp = t.root;
	for (int i = 0; i < str.toCharArray().length; i++) {
	    TrieNode t = temp.nodes[str.charAt(i) - 'a'];
	    if (t != null && t.c == str.charAt(i) && i == str.length() - 1)
		return t.words;
	    else if (t != null)
		temp = t;
	    else
		return 0;
	}
	return 0;
    }

    private static void add(String contact) {
	t.add(contact);
    }
}

class TrieNode {
    public TrieNode(char c) {
	this.c = c;
    }

    public char c;
    public boolean isWord;
    public int words = 0;
    public TrieNode[] nodes = new TrieNode[26];

    @Override
    public String toString() {
	return "TrieNode [c=" + c + ", isWord=" + isWord + ", words=" + words + ", nodes=" + Arrays.toString(nodes)
		+ "]";
    }
}

class Trie {

    TrieNode root = new TrieNode('_');

    public void add(String str) {
	TrieNode temp = root;
	if (str != null) {
	    for (int i = 0; i < str.length(); i++) {
		TrieNode ty = temp.nodes[str.charAt(i) - 'a'];
		if (ty == null) {
		    ty = new TrieNode(str.charAt(i));
		    temp.nodes[str.charAt(i) - 'a'] = ty;
		}
		ty.words++;
		temp = ty;
	    }
	    temp.isWord = true;
	}
    }
}