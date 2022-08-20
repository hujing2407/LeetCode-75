package Level_1;
public class FloodFill {
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     int temp = image[sr][sc];
    //     image[sr][sc]=color;
    //     if(sr>0 && image[sr-1][sc] == temp && image[sr-1][sc] != color){
    //         floodFill(image,  sr-1,  sc, color);
    //         image[sr-1][sc] = color;
    //     }
    //     if(sr+1<image.length && image[sr+1][sc] == temp&& image[sr+1][sc] != color){
    //         floodFill(image,  sr+1,  sc, color);
    //         image[sr+1][sc] = color;
    //     }
    //     if(sc>0 && image[sr][sc-1] == temp&& image[sr][sc-1] != color){
    //         floodFill(image,  sr,  sc-1, color);
    //         image[sr][sc-1] = color;
    //     }
    //     if(sc+1<image[0].length && image[sr][sc+1] == temp&& image[sr][sc+1] != color){
    //         floodFill(image,  sr,  sc+1, color);
    //         image[sr][sc+1] = color;
    //     }
    //     return image;
    // } 
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }  
}
