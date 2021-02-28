class Trie {
    private class TrieNode{ // 内部类， 创建字典树节点
        boolean isEnd;  // 是否为结尾
        TrieNode[] next;  // 下一个字母指向

        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){  // 遍历字符串的每个char
            if (node.next[w[i]-'a'] == null){  // 如果指向为空， 则新建节点
                node.next[w[i]-'a'] = new TrieNode();
            }
            node = node.next[w[i]-'a']; // 1. 如果节点存在 直接指向下个节点 2. 如果节点不存在， 则在新建节点之后指向下个节点
        }
        node.isEnd = true;  // 将最后一个节点设置成结束节点
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){
            if (node.next[w[i]-'a'] != null){  // 如果节点存在 则向下移动
                node = node.next[w[i]-'a'];
            }else{  // 如果节点不存在， 则不存在此单词
                return false;
            }

        }
        return node.isEnd;  // 如果移动到了最后， 发现是一个单词的结尾， 则返回true. 否则只是一个单词的前缀， 返回false(单词还未结束)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){
            if (node.next[w[i]-'a'] != null){
                node = node.next[w[i]-'a'];
            }else{
                return false;
            }

        }
        return true;  // 如果能遍历到最后一个字符， 一定存在 这个前缀/有可能是完整的word
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */