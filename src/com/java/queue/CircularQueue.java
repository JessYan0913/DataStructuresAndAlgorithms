package com.java.queue;

public class CircularQueue {

    private Long[] array;

    private int head;

    private int foot;

    public CircularQueue() {
        init(10);
    }

    public CircularQueue(int length) {
        init(length);
    }

    private void init(int length) {
        array = new Long[length];
        head = 0;
        foot = -1;
    }

    public boolean offer(long value) {
        if (foot == array.length) {
            return false;
        }
        array[++foot] = value;
        return true;
    }

    public Long poll() {
        return isEmpty() ? null : array[head++];
    }

    public Long peek() {
        return isEmpty() ? null : array[head];
    }

    public int size() {
        return Math.max(0, foot - head + 1);
    }

    public void show() {
        System.out.print("[");
        for (int i = head; i <= foot; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("]");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == array.length;
    }

}
