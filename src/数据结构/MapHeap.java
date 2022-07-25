package 数据结构;

public class MapHeap {
    /**
     * 堆容量
     */
    private final int cap;
    /**
     * 当前堆内元素,也是最后一个元素的下标
     */
    protected int count;
    protected Integer[] data;

    public MapHeap(int cap) {
        this.cap = cap + 1;
        data = new Integer[this.cap];
    }

    public MapHeap(Integer[] nums) {
        this.cap = nums.length + 1;
        this.data = new Integer[this.cap];
        System.arraycopy(nums, 0, this.data, 1, nums.length);
        count = nums.length;
        //        headpify 从最后一个非叶子节点开始
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }


    public void insert(Integer val) {
        if (count == cap) {
            throw new RuntimeException("容量已满");
        }
        count++;
        data[count] = val;
        shiftUp(count);
    }

    public Integer pop() {
        if (count == 0) {
            return null;
        }
        Integer val = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return val;
    }


    private void shiftUp(int index) {
        while (index > 1 && data[index] > data[index / 2]) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void shiftDown(int index) {
        while (index * 2 <= count) {
            int b = index * 2;
            if (index * 2 + 1 <= count && data[b + 1] > data[b]) {
//                找到两个子节点中较大值对应的索引
                b++;
            }
//            父节点比子节点最大值还大，无需操作
            if (data[index] > data[b]) {
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
        Integer temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp;
    }


}
