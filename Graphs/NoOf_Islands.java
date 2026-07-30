public class NoOf_Islands {
    public static void main(String[] args) {

        char [][] grid = {
                {'1','0','1','1'},
                {'1','0','0','1'},
                {'0','0','1','0'},
                {'1','1','0','0'},
        };

        island obj = new island(); // create Object
        int answer = obj.numIsland(grid);

        System.out.println(answer);
    }
    static class island{

        public int numIsland(char[][] grid){
            int rows = grid.length;
            int cols = grid[0].length;

            int count = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <cols ; j++) {
                    if(grid[i][j] =='1'){
                        count++;
                        dfs(grid , i ,j);
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid , int row , int col){
            // Base Case
            if(row<0 || row>= grid.length ||
               col<0 || col>= grid[0].length||
                    grid[row][col] == '0'
            ){
                return;
            }
            // Mark visited
            grid[row][col] ='0';
            
            dfs(grid, row-1 , col);

            dfs(grid , row+1 ,col);
            // Moves Left
            dfs(grid, row , col -1);
            // Moves Right
            dfs(grid ,row ,col+1);
        }
    }
}
