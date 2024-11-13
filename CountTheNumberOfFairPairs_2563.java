class Solution 
{
    public long checkPairs(int nums[], int value)
    {
        long ans = 0;
        int start = 0;
        int end = nums.length-1;

        while(start<end)
        {
            int sum = nums[start] + nums[end];

            if(sum < value)
            {
                ans += (end - start);
                start++;
            }
            else 
            {
                end--;
            }
        }

        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) 
    {
        Arrays.sort(nums);

        return checkPairs(nums, upper+1) - checkPairs(nums, lower);
    }
}