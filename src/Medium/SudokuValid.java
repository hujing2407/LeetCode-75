package Medium;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Aug. 17 2023
 */
public class SudokuValid {
  public boolean isValidSudoku1(char[][] board) {
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int bi = i / 3, bj = j / 3;
        char num = board[i][j];
        if (board[i][j] != '.') {
          if (!set.add(num + "-row-" + i) ||
              !set.add(num + "-col-" + j) ||
              !set.add(num + "-block-" + i / 3 + j / 3)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    HashSet<Character>[] rowSets = new HashSet[9];
    HashSet<Character>[] colSets = new HashSet[9];
    HashSet<Character>[][] blockSets = new HashSet[3][3];
    for (int i = 0; i < 9; i++) rowSets[i] = new HashSet<>();
    for (int i = 0; i < 9; i++) colSets[i] = new HashSet<>();
    for (int i = 0; i < 9; i++) blockSets[i / 3][i % 3] = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int bi = i / 3, bj = j / 3;
        if (board[i][j] == '.') continue;

        if (!rowSets[i].add(board[i][j])) return false;
        if (!colSets[j].add(board[i][j])) return false;
        if (!blockSets[bi][bj].add(board[i][j])) return false;
      }
    }

    return true;
  }
}
