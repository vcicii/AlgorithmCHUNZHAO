public class Search2DMat {
    // 先找 所在行， 降为一维。

    // 从右上角向左下角查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                System.out.println(matrix[row][col]);
                col--;
            }else{
                System.out.println(matrix[row][col]);
                row++;
            }
        }
        return false;
    }
}
