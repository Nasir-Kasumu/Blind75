package Tries;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curNode = root;
            char [] arr = word.toCharArray();
            for(char curChar : arr){
                if(curNode.children.containsKey(curChar) == false){
                    curNode.children.put(curChar, new TrieNode());
                }
                curNode = curNode.children.get(curChar);
            }
            curNode.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curNode = root;
            char [] arr = word.toCharArray();
            for(char curChar : arr){
                if(curNode.children.containsKey(curChar) == false){
                    return false;
                }
                curNode = curNode.children.get(curChar);
            }
            return curNode.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            char [] arr = prefix.toCharArray();
            for(char curChar : arr){
                if(curNode.children.containsKey(curChar) == false){
                    return false;
                }
                curNode = curNode.children.get(curChar);
            }
            return true;
        }
    }
}
