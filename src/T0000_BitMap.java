import java.util.Arrays;

/**
 * 通过位图实现一下功能
 * 添加和删除int，判断某个值是否存在
 * 假设需要一个存储100个int的数组，如果使用传统数组最少是需要100个int，3200位、400字节（一个int = 32位或4字节）
 * 如果使用位图则只需要两个long ，124位，16字节
 */
public class T0000_BitMap {
    long[] array;
    long maxValue;
    public T0000_BitMap(int max){
        maxValue = max;
        // 加一给0 预留空间
        max+=1;
        // 获取当前位图所需的数组长度，按照十进制计算需要 max/64 并向上取整 （因为我们使用long的数组所以是除64）
        // 整除需要几位
        int i = max >> 6;
        // 是否有余数
        // 如果余数大于0则数组最终成长度位i+1
        // 没有余数数组长度直接i即可
        i = subtraction(max, i << 6) ==0 ? i :add(i,1);
//        System.out.println(i);
        array = new long[i];
    }

    public void add(int num){
//        num+=1;
        if (num>maxValue){
            System.out.println("error");
        }else{
            // 首先计算num应该存在数组的第几位
            int index = num >> 6;
            // 取余确定是long中的第几位
            int i = num & (subtraction(64 , 1));
            // 将数组中的第index值中的第i位设置位1
            this.array[index] = this.array[index] | (1L << i);
        }
    }

    public boolean isSet(int num){
        if (num>maxValue){
            return false;
        }else {
            // 首先计算num应该存在数组的第几位
            int index = num >> 6;
            // 取余确定是long中的第几位
            int i = num & (subtraction(64 , 1));
            // 判断是否为1
            return ((array[index] >> i) & 1) == 1;
        }
    }

    public static int add(int a, int b) {
        int i = a ^ b;
        int j = (a & b) << 1;
        return j == 0 ? i : add(i,j);
    }

    public static int subtraction(int a, int b){
        return add(a,add(~b,1));
    }

    public static void main(String[] args) {
        T0000_BitMap bitMap = new T0000_BitMap(192);
        bitMap.add(5);
        bitMap.add(15);
        bitMap.add(6);
        bitMap.add(7);
        bitMap.add(54);
        bitMap.add(193);
        System.out.println(bitMap.isSet(1));
        System.out.println(bitMap.isSet(3));
        System.out.println(bitMap.isSet(5));
        System.out.println(bitMap.isSet(7));

    }


}
