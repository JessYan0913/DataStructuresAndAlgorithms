package com.java.array;

public class SortArrayList {

    private long[] array;

    private int effectiveLength;

    public SortArrayList() {
        array = new long[64];
    }

    public SortArrayList(int length) {
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        array = new long[length];
    }

    /**
     * 拆入数据
     *
     * @param value
     */
    public void insert(long value) {
        //当有效长度超过数组长度时，对数组扩容
        if (!(effectiveLength < array.length)) {
            //创建一个原数组长度*2的新数组
            long[] newArray = new long[array.length * 2];
            //将原数组从0开始，复制到新数组从0开始的位置，复制长度为原数组的长度
            System.arraycopy(array, 0, newArray, 0, array.length);
            //将新数组赋值给原数组
            array = newArray;
        }

        //定义指针
        int i;
        //遍历找到比插入值大的元素位置
        for (i = 0; i < effectiveLength; i++) {
            if (array[i] > value) {
                break;
            }
        }
        //判断有效指针和指针的距离是否大于等于0
        if (effectiveLength - i >= 0) {
            //如果有效指针和指针距离大于等于0，说明中间存在元素，将后面的元素整体向后迁移1位，空出指针的位置
            System.arraycopy(array, i, array, i + 1, effectiveLength - i);
        }
        array[i] = value;
        effectiveLength++;
    }

    /**
     * 打印array
     */
    public void show() {
        System.out.print("[");
        for (int i = 0; i < effectiveLength; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print("]\n");
    }

    /**
     * 使用二分法查找数据的下标
     *
     * @param value
     * @return
     */
    public int indexOf(long value) {
        //采用二分法查找
        //定义中指针
        int middle;
        //定义底部指针，从0开始
        int low = 0;
        //定义顶部指针，为有效指针
        int pow = effectiveLength;
        while (true) {
            //计算中指针位置
            middle = (pow + low) / 2;
            //判断中指针上元素与查找值是否相同
            if (array[middle] == value) {
                //相同返回中指针
                return middle;
            } else if (array[middle] > value) {
                //顶部指针指向中指针前一位
                pow = middle - 1;
            } else {
                //底部指针指向中指针后一位
                low = middle + 1;
            }
            //若顶部指针小于底部指针，则说明不存在该查找值
            if (pow < low) {
                return -1;
            }
        }
    }

    /**
     * 使用递归的方式实现二分法查找
     *
     * @param value
     * @return
     */
    public int recursiveIndexOf(long value) {
        //采用递归的方式实现二分法
        return queryValue(value, 0, effectiveLength);
    }

    private int queryValue(long value, int low, int pow) {
        if (pow < low) {
            return -1;
        }
        int middle = (low + pow) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            //递推关系
            return queryValue(value, low, middle - 1);
        } else {
            //递推关系
            return queryValue(value, middle + 1, pow);
        }
    }

    /**
     * 根据下标获取数据
     *
     * @param index
     * @return
     */
    public long get(int index) {
        //如果查找的下标小于0，或者大于等于有效指针，则查找的下标无效
        if (index < 0 || index >= effectiveLength) {
            throw new ArrayIndexOutOfBoundsException("指针越界");
        }
        return array[index];
    }

    /**
     * 根据下标修改数据
     *
     * @param index
     * @param value
     */
    public void change(int index, long value) {
        //如果查找的下标小于0，或者大于等于有效指针，则查找的下标无效
        if (index < 0 || index >= effectiveLength) {
            throw new ArrayIndexOutOfBoundsException("指针越界");
        }
        array[index] = value;
    }

    /**
     * 根据下表删除数据
     *
     * @param index
     */
    public void delete(int index) {
        //如果查找的下标小于0，或者大于等于有效指针，则查找的下标无效
        if (index < 0 || index >= effectiveLength) {
            throw new ArrayIndexOutOfBoundsException("指针越界");
        }
        //将数组元素在index位置上整体前移一个位置，有效长度-1
        System.arraycopy(array, index + 1, array, index, effectiveLength--);
    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int size() {
        return effectiveLength;
    }
}
