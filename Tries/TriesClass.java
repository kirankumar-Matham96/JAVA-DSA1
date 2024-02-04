package Tries;

import javax.swing.*;

class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }
}

public class TriesClass {
    private TrieNode root;
    private final int ALPHABET_SIZE = 26;

    public TriesClass(){
       root = new TrieNode('\0');
    }

    public TrieNode getRoot(){
        return this.root;
    }

    private void addHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        // assuming all the characters are in upper case
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        addHelper(child, word.substring(1));
    }

    public void add(String word) {
        addHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0){
            return root.isTerminal;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return searchHelper(child, word.substring(1));
    }
    public boolean search(String word) {
        return searchHelper(root,word);
    }


    public int wordsInTrie(){
        return countWords(this.root);
    }

    public int countWords(TrieNode root) {
        int count = 0;
        // count the terminal nodes == words in the trie
        // for every node, search the index that is not null
        // then check if it is terminal?
        // if yes, then increase the count
        // if not, check the same with it's children

        if(root.isTerminal){
            // System.out.println("Root is terminal!");
            count++;
        }

        for(int i=0; i < ALPHABET_SIZE; i++){
            if(root.children[i] != null){
                count += countWords(root.children[i]);
            }
        }

        return count;
    }

    private void removeHelper(TrieNode root, String word){

        if(word.length() == 0){
            root.isTerminal = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        if(child == null){
            return;
        }

        removeHelper(child, word.substring(1));
        if(!child.isTerminal && child.childCount == 0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public void remove(String word) {
        removeHelper(root, word);
    }
}
