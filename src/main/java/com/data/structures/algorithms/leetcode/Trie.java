package com.data.structures.algorithms.leetcode;

// Java implementation of delete
// operations on Trie

import java.util.*;
import java.io.*;
import java.lang.*;

public class Trie {
    static int ALPHABATE_SIZE=26;

    // Trie node
    static class TrieNode
    {
        TrieNode children[]=new TrieNode[ALPHABATE_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        // Returns new trie node (initialized to NULLs)
        public TrieNode()
        {
            isEndOfWord=false;
            for(int i = 0; i<ALPHABATE_SIZE;i++)
            {
                children[i]=null;
            }
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(String key)
    {
        int level;
        int length=key.length();
        int index;
        TrieNode pCrawl=root;
        for(level = 0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            {
                pCrawl.children[index]=new TrieNode();
            }
            pCrawl=pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord=true;
    }

    // Returns true if key presents in trie, else
    // false
    static boolean search(String key)
    {
        int index;
        int length=key.length();
        int level;
        TrieNode pCrawl=root;

        for(level = 0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            {
                return false;
            }
            pCrawl=pCrawl.children[index];
        }

        if(pCrawl!=null && pCrawl.isEndOfWord)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Returns true if root has no children
    // else false
    static boolean hasNoChild(TrieNode currentNode)
    {
        for(int level=0;level<currentNode.children.length;level++)
        {
            if(currentNode.children[level]!=null)
            {
                return false;
            }
        }

        return true;
    }

    static boolean removeUtil(TrieNode currentNode,String key,
                              int level,int length)
    {
        // If tree is empty
        if(currentNode==null)
        {
            System.out.println("Does not exist");
            return false;
        }

        // If last character of key is being processed
        if(level==length)
        {

            // This node is no more end of word after
            // removal of given key
            currentNode.isEndOfWord=false;

            // If given is not prefix of any other word
            if(hasNoChild(currentNode))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else{

            // If not last character, recur for the child
            // obtained using ASCII value
            TrieNode childNode =
                    currentNode.children[key.charAt(level)-'a'];

            boolean childDeleted =
                    removeUtil(childNode,key,level+1,length);

            if(childDeleted)
            {
                // If root does not have any child
                //(its only child got
                // deleted), and it is not end of another word.
                return (currentNode.isEndOfWord
                        &&hasNoChild(currentNode));
            }
        }

        return false;
    }

    // Recursive function to delete a key
    // from given Trie
    static void remove(String key)
    {
        int length=key.length();

        if(length>0)
        {
            removeUtil(root,key,0,length);
        }
    }


    // Driver Code
    public static void main(String[] args)
    {
        // Input keys (use only 'a' through 'z'
        // and lower case)
        root=new TrieNode();

        String keys[]= {"the", "a", "there",
                "answer", "any", "by","bye", "their",
                "hero", "heroplane"};

        // Construct trie
        for (int i = 0; i < keys.length; i++)
        {
            insert(keys[i]);
        }

        // Search for different keys
        if(search("the") == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        if(search("these") == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        remove("heroplane");

        if(search("hero") == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

class TrieNode {
    TrieNode child[];
    boolean isEnd;

    TrieNode() {
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        int length = word.length();
        TrieNode currNode = root;
        for(int i = 0; i < length; i++) {
            int idx = word.charAt(i) - 'a';
            if(currNode.child[idx] == null) {
                currNode.child[idx] = new TrieNode();
            }
            currNode = currNode.child[idx];
        }
        currNode.isEnd = true;
    }

    public boolean backtrack(TrieNode node, String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            int idx;
            if (word.charAt(i) != '.') {
                idx = word.charAt(i) - 'a';
                if (node.child[idx] == null) {
                    return false;
                }
            } else {
                int a = 0;
                while(a < 26) {
                    if (node.child[a] != null) {
                        if (backtrack(node.child[a], word.substring(i+1, length)))
                            return true;
                    }
                    a++;
                }
                return false;
            }
            node = node.child[idx];
        }
        return word.charAt(length-1) == '.' ? true : node.isEnd;
    }

    public boolean search(String word) {
        return backtrack(root, word);
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        dict.addWord("pad");
        System.out.println(dict.search(".ad"));
    }
}

class WordSearchII {
    TrieNode root;
    static boolean[][] visited;
    public void existRecursive(char[][] board, int i, int j, String word, List<String> res) {

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        word += board[i][j];
        TrieNode currNode = getLast(word);
        if (currNode == null) {
            return;
        }

        if (currNode.isEnd && !res.contains(word)){
            res.add(word);
        }

        visited[i][j] = true;
        existRecursive(board, i-1, j, word, res);
        existRecursive(board, i+1, j, word, res);
        existRecursive(board, i, j-1, word, res);
        existRecursive(board, i, j+1, word, res);
        visited[i][j] = false;
    }


    public List<String> findAllWords(char[][] board) {
        List<String> res = new ArrayList<>();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                existRecursive(board, i, j, "", res);
            }
        }
        return res;
    }

    public void insert(String word) {
        TrieNode dummy = root;
        for (int i =0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (dummy.child[idx] == null) dummy.child[idx] = new TrieNode();
            dummy = dummy.child[idx];
        }
        dummy.isEnd = true;
    }

    public TrieNode getLast(String word) {
        TrieNode currNode = root;
        for (int i =0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (currNode.child[idx] == null) return null;
            currNode = currNode.child[idx];
        }
        return currNode;
    }



    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        return findAllWords(board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        System.out.println(new WordSearchII().findWords(board, new String[] {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"}));
    }
}
