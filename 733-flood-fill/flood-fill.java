class Solution {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] visited, int orgColor) {
        // Boundary conditions
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || visited[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }

        // Mark visited
        visited[sr][sc] = true;

        // Color the current pixel
        image[sr][sc] = color;

        // Move in 4 directions
        helper(image, sr, sc - 1, color, visited, orgColor); // left
        helper(image, sr, sc + 1, color, visited, orgColor); // right
        helper(image, sr - 1, sc, color, visited, orgColor); // top
        helper(image, sr + 1, sc, color, visited, orgColor); // bottom
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int orgColor = image[sr][sc];

        // Only fill if new color is different from original
        if (orgColor != color) {
            helper(image, sr, sc, color, visited, orgColor);
        }

        return image;
    }
}