import java.util.*;

class Solution9 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num =1;
        int startrow = 0;
        int endrow = n-1;
        int startcol = 0;
        int endcol = n-1;

        while(startrow<=endrow && startcol<=endcol){
            //top
            for(int j=startcol;j<=endcol;j++){
                result[startrow][j]= num++;
            }
            // right
            for(int i=startrow+1;i<=endrow;i++){
                result[i][endcol]= num++;
            }
            //bottom 
            for(int j=endcol-1;j>=startcol;j--){
                if(startrow==endrow){
                    break;
                }
                result[endrow][j]= num++;
            }
            // left
            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcol==endcol){
                    break;
                }
                result[i][startcol]= num++;
            }
            startrow ++;
            startcol++;
            endrow --;
            endcol --;

        }
        return result;

        
    }
}
