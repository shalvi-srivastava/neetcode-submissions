class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    public void merge(int[] a, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            merge(a, i, mid);
            merge(a, mid + 1, j);
            mergeSort(a, i, j, mid);
        }

    }

    public void mergeSort(int[] a, int si, int ei, int mid) {
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;
        while (i <= mid && j <= ei) {
            if (a[i] > a[j]) {
                temp[k++] = a[j++];
            } else {
                temp[k++] = a[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= ei) {
            temp[k++] = a[j++];
        }
        i = si;
        for (k = 0; k < temp.length; k++) {
            a[i++] = temp[k];
        }
    }
}
