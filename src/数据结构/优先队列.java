package 数据结构;

public class 优先队列<T extends Comparable> {
    /**
     * 堆容量
     */
    private int cap;
    /**
     * 当前堆内元素,也是最后一个元素的下标
     */
    protected int count;
    protected T[] data;

    public 优先队列(int cap) {
        this.cap = cap + 1;
        data = (T[]) new Comparable[this.cap];
    }


    public void insert(T val) {
        if (count == cap) {
            throw new RuntimeException("容量已满");
        }
        count++;
        data[count] = val;
        shiftUp(count);
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        T val = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return val;
    }


    private void shiftUp(int index) {
        while (index > 1 && data[index].compareTo(data[index / 2]) > 0) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void shiftDown(int index) {
        while (index * 2 <= count) {
            int b = index * 2;
            if (index * 2 + 1 <= count && data[b + 1].compareTo(data[b]) > 0) {
                b++;
            }
            if (data[index].compareTo(data[b]) > 0) {
                break;
            }
            swap(index, b);
            index = b;
        }
    }

    public int size() {
        return count;
    }

    private void swap(int a, int b) {
        T temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp;
    }


}
