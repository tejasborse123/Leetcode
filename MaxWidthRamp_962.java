class Solution 
{
    public int maxWidthRamp(int[] nums) 
    {
        int len = nums.length;
        int min[] = new int[len];
        int max[] = new int[len];
        min[0] = nums[0];    
        max[len-1] = nums[len-1];    

        for(int i=1; i<len; i++) min[i] = Math.min(min[i-1], nums[i]);
        for(int i=len-2; i>=0; i--) max[i] = Math.max(max[i+1], nums[i]);

        int ans = 0;
        int i = 0, j = 0;

        while(j < len)
        {
            if(min[i] <= max[j])
            {
                ans = Math.max(ans, j-i);
                j++;
            }
            else
            {
                i++;
            }
        }

        return ans;
    }
}