import java.util.*;

class Solution8 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return result;

        int startrow = 0;
        int endrow = matrix.length-1;
        int startcol = 0;
        int endcol = matrix[0].length-1;

        // condition for the loop
        while(startrow<=endrow && startcol<=endcol){
            // Printing the Top
            for(int j=startcol;j<=endcol;j++){
                result.add(matrix[startrow][j]);
            }
            // Printing the right 
            for(int i=startrow+1;i<=endrow;i++){

                result.add(matrix[i][endcol]);
            }
            // Printing the bottom 
            for(int j=endcol-1;j>=startcol;j--){
                if(startrow==endrow){
                    break;
                }
                result.add(matrix[endrow][j]);
            }
            // Printing the left
            for(int i=endrow-1;i>=startrow+1;i--){
                if (startcol==endcol){
                    break;
                }
                result.add(matrix[i][startcol]);
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        return result;
    }
}
