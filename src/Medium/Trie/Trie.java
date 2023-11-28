package Medium.Trie;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class Trie {
  private Trie[] children;
  private boolean isEnd;

  public Trie() {
    this.children = new Trie[26];
    this.isEnd = false;
  }

  public void insert(String word) {
    Trie node = this;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null)
        node.children[c - 'a'] = new Trie();
      node = node.children[c - 'a'];
    }
    node.isEnd = true;
  }

  public boolean search(String word) {
    Trie node = searchPrefix(word);
    return node != null && node.isEnd;
  }

  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }

  public Trie searchPrefix(String prefix) {
    Trie node = this;
    for (char c : prefix.toCharArray()) {
      if (node.children[c - 'a'] == null) return null;
      node = node.children[c - 'a'];
    }

    return node;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // 返回 True
    trie.search("app");     // 返回 False
    trie.startsWith("app"); // 返回 True
    trie.insert("app");
    trie.search("app");     // 返回 True
  }
}
