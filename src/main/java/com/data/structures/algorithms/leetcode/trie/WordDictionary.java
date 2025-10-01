package com.data.structures.algorithms.leetcode.trie;


class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;
    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}



class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word.isEmpty()) return;
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfsSearch(word, 0, curr);
    }

    public boolean dfsSearch(String word, int index, TrieNode node) {
        if (index == word.length())
            return node.isEndOfWord;
        char c = word.charAt(index);
        if (c == '.') {
           for (TrieNode n: node.children) {
               if (n != null && dfsSearch(word, index+1, n))
                   return true;
           }
        } else {
           if (node.children[c - 'a'] == null)
               return false;
           return dfsSearch(word, index+1, node.children[c - 'a']);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));

    }
}