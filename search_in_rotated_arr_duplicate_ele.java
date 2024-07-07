public class search_in_rotated_arr_duplicate_ele {
    public static void main(String[] args) {
        int nums[] = {3, 5, 7, 9, 4};
        int target = 7;
        int ans = search(nums, target);
        System.out.println(ans);
    }

    public static int search(int nums[], int target) {
        int pivot = findele(nums);
        if (pivot != -1 && nums[pivot] == target) {
            return pivot;
        }
        if (pivot == -1) {
            return findEle(nums, target, 0, nums.length - 1);
        }
        if (nums[0] <= target) {
            return findEle(nums, target, 0, pivot - 1);
        }
        return findEle(nums, target, pivot + 1, nums.length - 1);
    }

    public static int findele(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            // Handling duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] < nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findEle(int nums[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
