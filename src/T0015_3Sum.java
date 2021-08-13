import java.util.*;

public class T0015_3Sum {
    public static void main(String[] args) {
        int[] i = {-1,0,1,2,-1,-4};
//        int[] i = {0,0,0,0};
        List<List<Integer>> list = threeSum(i);
        System.out.println(list);
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if(nums.length < 3) return list;
//        Arrays.sort(nums);
//        int a = 0;
//        int b = 1;
//        int c = 2;
//        while (a<nums.length){
//            a++;
//        }
//        return null;
//    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        if(nums.length < 3) return new LinkedList<>(list);
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        for (int i = 0; i < nums.length; i++) { ;
            for (int j = i+1; j < nums.length; j++) {
//                if (j>=2 && nums[j]==nums[j-1]) continue;
                int t = nums[i] + nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int t2 = t + nums[k];
                    if (t2==0){
                        LinkedList<Integer> integers = new LinkedList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        list.add(integers);
                        break;
                    }else if(t2+max <0){
                        break;
                    }

                }
            }
        }
        return new LinkedList<>(list);
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
