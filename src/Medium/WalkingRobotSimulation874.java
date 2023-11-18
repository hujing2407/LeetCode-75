package Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jing Hu
 * @date Nov. 17 2023
 */
public class WalkingRobotSimulation874 {
  public static int robotSim(int[] commands, int[][] obstacles) {
    Set<Integer> set = new HashSet<>();
    for (int[] obs : obstacles) {
      set.add(obs[0]*60001 + obs[1]);
    }

    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // North, East, South, West
    int[] pos = {0, 0};
    int max = 0;

    int di = 0; // direct index
    for (int com : commands) {
      if (com == -1) di = (di + 1) & 3;
      else if (com == -2) di = ((di - 1)+4) & 3;
      else {
//        pos = move(obstacles, pos, direct, di, com);
        while (com-- > 0 && !set.contains((pos[0] + direct[di][0]) * 60001 + (pos[1] + direct[di][1]))) {
          pos[0] += direct[di][0];
          pos[1] += direct[di][1];
        }

        int temp = pos[0] * pos[0] + pos[1] * pos[1];
        max = max > temp ? max : temp;
      }
    }

    return max;
  }


  private static int[] move(int[][] obstacles, int[] pos, int[][] direct, int di, int com) {
    int x = direct[di][0] * com + pos[0];
    int y = direct[di][1] * com + pos[1];

    for (int[] ob : obstacles) {
      if(pos[0] == ob[0] && di == 0 ){
        if(ob[1] > pos[1] && ob[1] <= y) y = ob[1]-1;
      }
      if(pos[0] == ob[0] && di == 2 ){
        if(ob[1] < pos[1] && ob[1] >= y) y = ob[1]+1;
      }
      if(pos[1] == ob[1] && di == 1 ){
        if(ob[0] > pos[0] && ob[0] <= x) x = ob[0]-1;
      }
      if(pos[1] == ob[1] && di == 3 ){
        if(ob[0] < pos[0] && ob[0] >= x) x = ob[0]+1;
      }

    }

    return new int[]{x,y};
  }

  public static void main(String[] args) {
    WalkingRobotSimulation874.robotSim(new int[]{-2,8,3,7,-1},
        new int[][]{ {-4,-1}, {1,-1}, {1,4}, {5,0}, {4,5}, {-2,-1}, {2,-5}, {5,1}, {-3,-1}, {5,-3} });
  }
}
