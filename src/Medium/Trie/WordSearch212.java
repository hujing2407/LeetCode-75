package Medium.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class WordSearch212 {
  int[][] di = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};// E,S,W,N

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode trie = new TrieNode();
    int m = board.length, n = board[0].length;
    List<String> res = new ArrayList<>();

    TrieNode root = buildTrie(words);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, root, i, j, res);
      }
    }

    return res;
  }

  private void dfs(char[][] board, TrieNode node, int i, int j, List<String> res) {
    char c = board[i][j];
    if (c == '#' || node.next[c - 'a'] == null) return;
    node = node.next[c - 'a'];
    if (node.word != null) {
      res.add(node.word);
      node.word = null;
    }

    board[i][j] = '#';
    for(int[] d:di){
      int i2 = i+d[0], j2 = j+d[1];
      if(i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length)
        dfs(board, node, i2, j2, res);
    }

    board[i][j] = c;
  }


  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode curr = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (curr.next[i] == null) curr.next[i] = new TrieNode();
        curr = curr.next[i];
      }
      curr.word = word;
    }
    return root;
  }

  class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }
}
