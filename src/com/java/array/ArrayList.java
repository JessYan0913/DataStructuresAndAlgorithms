package com.java.array;

public class ArrayList {

    private long[] array;

    private int effectiveLength;

    public ArrayList() {
        array = new long[64];
    }

    public ArrayList(int length) {
        array = new long[length];
    }

    /**
     * 插入数据
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

        //在数组的最后一位插入值
        array[effectiveLength] = value;
        //有效长度指针+1
        effectiveLength++;
    }

    /**
     * 打印array数据
     */
    public void show() {
        System.out.print("[");
        for (int i = 0; i < effectiveLength; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print("]\n");
    }

    /**
     * 查询数据
     *
     * @param value
     * @return
     */
    public int indexOf(long value) {
        //定义指针
        int i;
        //遍历整个数组
        for (i = 0; i < effectiveLength; i++) {
            //如果指针位置的元素与查找值相同，退出循环
            if (array[i] == value) {
                break;
            }
        }
        //如果指针遍历完全部的元素，指针值与有效指针相同，表示查找值不存在，i=-1
        if (i == effectiveLength) {
            i = -1;
        }
        return i;
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
     * 根据下标删除数据
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
