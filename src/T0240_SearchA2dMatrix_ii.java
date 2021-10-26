public class T0240_SearchA2dMatrix_ii {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = {{5},{6}};
//        int[][] matrix = {{-1,3}};
//        int[][] matrix = {{-5}};
        int target = 5;
        boolean r = searchMatrix1(matrix,target);
        System.out.println(r);
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了8.89%的用户
     * 内存消耗：43.8 MB, 在所有 Java 提交中击败了66.83%的用户
     * 通过测试用例：129 / 129
     * 思路一:从左上角第一个元素开始，从上往下比较，如果到底或者大于target值则进入下一列。
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

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了15.10%的用户
     * 内存消耗：43.5 MB, 在所有 Java 提交中击败了94.31%的用户
     * 思路二：其实整个数组矩阵是局部有序的,取中间行开始比较
     */
    public static boolean searchMatrix1(int[][] matrix, int target){
        int mid = matrix.length/2;
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[mid][i] == target) {
                return true;
            }else if(matrix[0][i] <= target){
                if(matrix[mid][i] > target){
                    // 如果比较值大于目标值则向上查询
                    for (int j = mid; j >= 0; j--) {
                        if (matrix[j][i] == target){
                            return true;
                        }else if (matrix[j][i] < target){
                            break;
                        }
                    }
                }else if(matrix[mid][i] < target) {
                    // 否则向下查询
                    for (int j = mid; j < matrix.length; j++) {
                        if (matrix[j][i] == target){
                            return true;
                        }else if (matrix[j][i] > target){
                            break;
                        }
                    }
                }
            }
        }
        return false;

    }


}
