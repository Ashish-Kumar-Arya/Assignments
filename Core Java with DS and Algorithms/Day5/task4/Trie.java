package assignments.day5.task4;

public class Trie {
    static final int ALPHABET_SIZE=26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord=false;
            for(int i=0; i<ALPHABET_SIZE; i++) {
                children[i]=null;
            }
        }
    }

        static void insert(TrieNode root, String key) {
            TrieNode curNode=root;
            for(int i=0; i<key.length(); i++) {
                 char cur=key.charAt(i);
                 if(curNode.children[cur-'a']==null) {
                    TrieNode newNode=new TrieNode();
                    curNode.children[cur-'a']=newNode;
                 }
                 curNode=curNode.children[cur-'a'];
            }
            curNode.isEndOfWord=true;
        }

        static boolean isPrefix(TrieNode root,String key) {
            TrieNode curNode=root;
            for(int i=0; i<key.length(); i++) {
                char cur=key.charAt(i);
                if(curNode.children[cur-'a']==null) {
                   return false;
                }
                curNode=curNode.children[cur-'a'];
           }
           return true;
        }

        public static void main(String[] args) {
            TrieNode root=new TrieNode();
            insert(root, "app");
            insert(root, "apple");
            System.out.println(isPrefix(root, "ap"));
        }
}
