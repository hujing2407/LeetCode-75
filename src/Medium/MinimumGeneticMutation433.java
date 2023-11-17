package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jing Hu
 * @date Nov. 15 2023
 */
public class MinimumGeneticMutation433 {
  public int minMutation(String startGene, String endGene, String[] bank) {
    int level = 0;
    HashSet<String> bankSet = new HashSet<>();
    for (String b : bank) bankSet.add(b);

    char[] charSet = {'A', 'C', 'G', 'T'};
    HashSet<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(startGene);
    visited.add(startGene);

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String curr = queue.poll();
        if (endGene.equals(curr)) return level;

        char[] currChars = curr.toCharArray();
        for (int i = 0; i < 8; i++) {
          char old = currChars[i];
          for (char c : charSet) {
            currChars[i] = c;
            String next = new String(currChars);
            if(!visited.contains(next) && bankSet.contains(next)){
              visited.add(next);
              queue.offer(next);
            }
          }
          currChars[i] = old;
        }
      }
      level++;
    }
    return -1;
  }
}
