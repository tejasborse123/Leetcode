// Solution 1 : Using extra 2D DP Array.

class Solution 
{
    public int countSquares(int[][] matrix) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows][cols];

        for(int i=0; i<rows; i++) dp[i][0] = matrix[i][0];
        for(int i=0; i<cols; i++) dp[0][i] = matrix[0][i];

        for(int i=1; i<rows; i++)
        {
            for(int j=1; j<cols; j++)
            {
                if(matrix[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1])) + 1;
            }
        }

        int Count = 0;

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++) 
            {
                Count += dp[i][j]; 
            }
        }

        return Count;
    }
}


// Solution 2 : In-place DP : [Without using extra Space] 


class Solution 
{
    public int countSquares(int[][] matrix) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=1; i<rows; i++)
        {
            for(int j=1; j<cols; j++)
            {
                if(matrix[i][j] == 1) 
                matrix[i][j] = Math.min(matrix[i-1][j-1] , Math.min(matrix[i-1][j] , matrix[i][j-1])) + 1;
            }
        }
        
        int Count = 0;

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++) 
            {
                Count += matrix[i][j]; 
            }
        }

        return Count;
    }
}


