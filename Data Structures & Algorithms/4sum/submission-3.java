class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, 0, target);
    }

    public List<List<Integer>> kSum(int[] nums, int k, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                long sum = nums[i] + nums[j];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return res;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> temp = kSum(nums, k - 1, i + 1, target - nums[i]);

            for (List<Integer> list : temp) {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                newList.addAll(list);
                res.add(newList);
            }
        }
        return res;
    }
}