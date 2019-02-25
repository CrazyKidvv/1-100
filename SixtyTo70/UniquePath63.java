package SixtyTo70;

public class UniquePath63 {
	public static void main(String[] args) {
		int[][] a = {{0,0},{0,1},{0,0}};
		int res = uniquePathsWithObstacles(a);
		System.out.println(res);
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==1) return 0;
        dp[0][0] = 1;
       
        if(m > 1) {
        	if(obstacleGrid[1][0] == 1) {
        		dp[1][0] = 0;
        	}else {
        		dp[1][0] = 1;
        	}
        }
        if(n > 1) {
        	if(obstacleGrid[0][1] == 1) {
        		dp[0][1] = 0;
            }else {
            	dp[0][1] = 1;
            }
        }
        	
        	for(int i = 2;i < m; i++) {
        		if(obstacleGrid[i][0] != 1) {
        			dp[i][0] = dp[i-1][0];
        		}else {
        			dp[i][0] = 0;
        		}
        	}
        	
        	for(int j = 2; j < n; j++) {
        		if(obstacleGrid[0][j] != 1) {
        			dp[0][j] = dp[0][j-1];
        		}else {
        			dp[0][j] = 0;
        		}
        	}
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		}else {
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        		}
        	}
        }
        return dp[m-1][n-1];
    }
}
