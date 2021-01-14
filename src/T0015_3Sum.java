import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0015_3Sum {
    public static void main(String[] args) {
        int[] i = {1,2,4,6,-2,-1,-5,0,-1,-1,-1,2,-4,9,-2,5};
//        int[] i = {0,0,0,0};
        List<List<Integer>> list = threeSumX(i);
        System.out.println(list);
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int[] arr = new int[3];
//            int t1 = nums[i];
//            System.out.println(t1);
//            arr[0] = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                arr[1] = nums[j];
//                t1+=nums[j];
//                System.out.println(t1);
//                for (int k = j+1; k < nums.length-j; k++) {
//                    if (k == j || k == i) continue;
//                    System.out.println(t1);
//                    System.out.println("-----");
//                    if (k == (3-t1)){
//                        arr[2] = nums[k];
////                        System.out.println(nums[i]);
////                        System.out.println(nums[j]);
////                        System.out.println(nums[k]);
////                        System.out.println("-----");
////                        System.out.println(Arrays.toString(arr));
//                    }
//                }
//            }
//
//        }
//        return null;
//    }

    public static List<List<Integer>> threeSumX(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            Integer[] arr = new Integer[3];
            for (int j = i+1; j < nums.length; j++) {
                if (j == i) continue;
                boolean flag = false;
                for (int k = j+1; k < nums.length; k++) {
                    if (k == i || k == j) continue;
                    if ((nums[j] + nums[k]) == -nums[i]) {
                        flag = true;
                        arr[0] = nums[i];
                        arr[1] = nums[j];
                        arr[2] = nums[k];
                        break;
                    }
                }
                if (flag) {
                    list.add(Arrays.asList(arr));
                    break;
                }
            }
        }
        return list;
    }
}
