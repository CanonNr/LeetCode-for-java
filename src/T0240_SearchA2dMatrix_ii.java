public class T0240_SearchA2dMatrix_ii {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = {{1},{6}};
//        int[][] matrix = {{-1,3}};
//        int[][] matrix = {{-5}};
        int target = 5;
        boolean r = searchMatrix(matrix,target);
        System.out.println(r);
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了8.89%的用户
     * 内存消耗：43.8 MB, 在所有 Java 提交中击败了66.83%的用户
     * 通过测试用例：129 / 129
     * 从左上角第一个元素开始，从上往下比较，如果到底或者大于target值则进入下一列。
     */
    public static boolean searchMatrix(int[][] matrix, int target){
        for (int i = 0; i < matrix[0].length; i++) {
            int x = 0;
            if(matrix[x][i] > target){
                return false;
            }else {
                for (x = 0; x < matrix.length; x++) {
                    if (matrix[x][i] == target){
                        return true;
                    }else if(matrix[x][i] > target){
                        break;
                    }
                }
            }
        }
        return false;
    }

}
