package offer;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0,j=0; i < temp.length&&j<nums.length; j++) {
            if (nums[j] != 0) {
                temp[i] = nums[j];
                i++;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        new 移动零().moveZeroes(new int[]{1,3,12,0,0});
    }
}
