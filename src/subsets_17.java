import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets_17 {

    public static void main(String arg[]) {
        int[] nums = {4,3,2,1,5};
        List<List<Integer>> ret = new subsets_17().subsets(nums);
        for (List<Integer> list : ret) {
            System.out.println(list);
        }
    }

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            ret.add(new ArrayList<>());
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            int buffer[] = new int[i];
            subsetshelper(ret, buffer, nums, 0, 0, i);
        }
        return ret;
    }

    private void subsetshelper(List<List<Integer>> ret, int[] buffer, int[] nums, int position, int index, int size) {
        if (index >= size) {
            List<Integer> list = new ArrayList<>();
            for (int num : buffer) {
                list.add(num);
            }
            ret.add(list);
            return;
        }
        for (int i = position; i < nums.length; i++) {
            buffer[index] = nums[i];
            subsetshelper(ret, buffer, nums, i + 1, index + 1, size);
        }
    }
}