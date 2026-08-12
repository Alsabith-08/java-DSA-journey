package ChatGPT_Problems.Graphs;

public class FloodFill {
    public static void main(String[] args) {

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image , sr , sc , color);

        System.out.println("Output");

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] floodFill(int[][] image , int sr , int sc , int color){

        int oldColor = image[sr][sc];

        if(oldColor == color ){
            return image;
        }

        dfs(image , sr , sc , oldColor , color);

        return image;
    }

    static void dfs(int[][] image , int row , int col , int oldColor , int color){

        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length){
            return;
        }

        if( image[row][col] != oldColor){
            return;
        }

        // change the color
        image[row][col] = color;

        // up
        dfs(image , row-1 , col , oldColor, color);

        // down
        dfs(image , row+1 , col , oldColor, color);

        // left
        dfs(image , row-1 , col-1 , oldColor, color);

        // right
        dfs(image , row-1 , col+1 , oldColor, color);
    }
}
