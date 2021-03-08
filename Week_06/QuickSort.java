public class QuickSort {
    public void sort(int[] nums, int low , int high){
        int idx = findIndex(nums, 0, nums.length -1 );
        sort(nums, low, idx - 1);
        sort(nums, idx + 1, high);
    }

    private int findIndex(int[] nums, int low, int high) {
        int mark = nums[low];
        while (low < high){
            while (nums[high] >= mark ){
                high--;
            }
            nums[low] = nums[high];
            while (nums[low] < mark){
                low++;
            }
            nums[high] = nums[low];
        }

        return low;
    }

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{4,3,1,4,5,1,56,7,3,4,1,54,54,2,12}, 0 , 14);
    }
}
