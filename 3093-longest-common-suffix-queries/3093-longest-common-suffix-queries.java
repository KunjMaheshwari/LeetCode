class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }

    TrieNode root = new TrieNode();
    String wordsContainer[];

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        this.wordsContainer = wordsContainer;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int ans[] = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    public void insert(String word, int index) {
        TrieNode node = root;
        updateBest(node, index);

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            updateBest(node, index);
        }
    }

    public int search(String query) {
        TrieNode node = root;
        for (int i = query.length() - 1; i >= 0; i--) {
            char ch = query.charAt(i);
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
        }
        return node.bestIndex;
    }

    public void updateBest(TrieNode node, int index) {
        if (node.bestIndex == -1) {
            node.bestIndex = index;
            return;
        }
        String currentBest = wordsContainer[node.bestIndex];
        String newWord = wordsContainer[index];

        if (newWord.length() < currentBest.length()) {
            node.bestIndex = index;
        } else if (newWord.length() == currentBest.length()
                && index < node.bestIndex) {
            node.bestIndex = index;
        }
    }
}