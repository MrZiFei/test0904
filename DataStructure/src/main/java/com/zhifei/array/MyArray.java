package com.zhifei.array;

public class MyArray<T> {
    //容器
    private T[] data;
    //容器中的元素个数(并非容量)
    private int size;

    //根据参数容量创建数组
    public MyArray(int capacity) {
        data = (T[]) new Object[capacity];
        //默认数组中没有元素
        size = 0;
    }

    //没有传递容量
    public MyArray() {
        //默认10个容量
        this(10);
    }

    //获得数组容量
    public int getCapacity() {
        return data.length;
    }

    //获得元素个数
    public int getSize() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //往数组末尾添加一个元素
    public void addLast(T e) {
        add(size, e);
    }

    //往指定位置添加元素，必须将指定位置后的元素往后移动
    public void add(int index, T e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("下标越界异常");
        }
        if (index == data.length) {
            resize(size * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //往头一个位置插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    //修改指定位置的元素
    public void set(int index, T e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("下标越界异常");
        }
        data[index] = e;
    }

    //打印数组中元素
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: size="+size + "; capacity=" + data.length);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    //查询是否包含元素
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return true;
            }
        }
        return false;
    }

    //查找元素的位置
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的元素，并返回元素本身
    public T remove(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("下标越界异常");
        }
        T e = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
//        data[size] = null;
        size--;
        if (size <= data.length / 2) {
            resize(data.length / 2);
        }
        return e;
    }

    //删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    //删除最后一个元素
    public T removeLast() {
        return remove(size - 1);
    }

    //删除指定元素
    public void removeElement(T e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }

    }

}
