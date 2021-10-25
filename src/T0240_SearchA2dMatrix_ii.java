public class T0240_SearchA2dMatrix_ii {
    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{1,1}};
        int target = 2;
        boolean r = searchMatrix(matrix,target);
        System.out.println(r);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        for (int i = 0 ; i < matrix[0].length ; i++ ) {
            // 相等直接返回true
            if (matrix[l][i] == target) return true;
            // 遇到大于则从上一位开始往下找
            if (matrix[l][i] > target){
                if (l<=0) return false;
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][l] == target) return true;
                    if (matrix[j][l] > target) return false;
                }
            }else {
                l++;
            }
        }

        return false;
    }
}
