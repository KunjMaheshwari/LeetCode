class Solution {
    class Node {
        Node children[] = new Node[26];
        int count = 0;

        Node () {
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }
    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.count++;
        }
    }
    public int calcn(String word) {
        Node curr = root;
        int finalres = 0;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            finalres += curr.children[idx].count;
            curr = curr.children[idx];
        }
        return finalres;
    }
    public int[] sumPrefixScores(String[] words) {
        for (String c: words) {
            insert(c);
        }
        int i = 0;
        int res[] = new int[words.length];
        for (String c: words) {
            res[i++] = calcn(c);
        }
        return res;
    }
}