class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // int n = nums.length;
        int longest = 0;
        int count = 0;
        for(int n:nums){
            if(n==1){
                count++;
                longest=Math.max(longest,count);
                
            }
            else{
                count=0;
            }
        }
        return longest;
    }
}