/**
 * @authoer Jing Hu
 * @create Jan 23 2021
 */
public class C_languageTest {

    public static void main(String[] args) {

//        int w=34;
//        int l=30;
//        int[] customers = {4,4,4,3,8,8,3,4,4,2,4,2};
        int w=50;
        int l=30;
        int[] customers = {1,2,12,1,2,8,2,5,8,2,3,8,3,12,1,1,2,1,6,3};

        int column = 0;
        int[][] map = null;
        map = new int[l/2][w/2];
        generateMap(map);
//        outputMap(map);
        for (int customer:customers) {
            if((column=findTable(map,customer))>0){
                System.out.printf("Table for %d was found in column %d",customer,(int)Math.ceil(column/6.0));
                System.out.println();
                outputMap(map);
                System.out.println();
            }else{
                System.out.printf("*** Table for %d was not available ***",customer);
                System.out.println();
            };

        }
    }

    /**
     *
     * @param map
     * @param p customer
     * @return
     */
    private static int findTable(int[][] map, int p) {
        int tableSize = (int) Math.ceil(p/2.0);
        for (int col = 2; col < map[0].length; col += 6) {
            for (int row = 1; row < map.length-tableSize; row++) {
                if(isTure(map,row, col, p)){
                    setTable(map,row,col,p);
                    return col;
                }
            }
        }
        return -1;
    }

    /**
     * verify the map[x][y] is suitable or not?
     * @param map restaurant layout
     * @param x row number
     * @param y column number
     * @param p person number
     * @return
     */
    private static boolean isTure(int[][] map, int x, int y, int p) {
        int tableSize = (int) Math.ceil(p/2.0);
        int lastT = map.length-1;
        while(lastT > 0 ){
            if(map[lastT][y] !=0)
                break;
            lastT--;
        }
        if(lastT == 0 && (tableSize+lastT)<map.length){
            return true;
        }else if ((x-lastT)>3 && (x+tableSize)<map.length){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param map restaurant layout
     * @param x row number
     * @param y column number
     * @param p person number
     */
    private static void setTable(int[][] map, int x, int y, int p) {
        int tableSize = (int) Math.ceil(p/2.0);

        for (int i = 0; i < tableSize; i++) {
            map[x][y] = 1;
            map[x][y+1] = 2;
            map[x][y-1] = 2;
            x++;
        }

    }

    private static void outputMap(int[][] map) {
        for (int i = 0; i <map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    System.out.print(".");
                }else if(map[i][j] == 1){
                    System.out.print("T");
                }else {
                    System.out.print("C");
                }
            }
            System.out.println();
        }
    }

    private static void generateMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
    }
}
