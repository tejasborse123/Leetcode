// Using Recursion.

class Solution 
{
	int targetOr;
	int len; 
	public int generateSubsetsAndRes(int nums[], int idx, int currOr)
	{
		if(idx == len) return (currOr == targetOr) ? 1 : 0;

		int pickNum = generateSubsetsAndRes(nums, idx+1, currOr | nums[idx]);
		int notPickNum = generateSubsetsAndRes(nums, idx+1, currOr);

		return pickNum + notPickNum;
	}
	public int countMaxOrSubsets(int[] nums) 
	{
		len = nums.length;
		for(int i=0; i<len; i++) targetOr |= nums[i];
		return generateSubsetsAndRes(nums, 0, 0);
	}
}




// Using DP : Dynamic Programming.


class Solution 
{
    int targetOr;
    int len; 
    Integer dp[][];
    public int generateSubsetsAndRes(int nums[], int idx, int currOr)
    {
        if(idx == len)  return (currOr == targetOr) ? 1 : 0;
        if(dp[idx][currOr] != null) return dp[idx][currOr];

        int pickNum = generateSubsetsAndRes(nums, idx+1, currOr | nums[idx]);
        int notPickNum = generateSubsetsAndRes(nums, idx+1, currOr);

        return dp[idx][currOr] = pickNum + notPickNum;
    }
    public int countMaxOrSubsets(int[] nums) 
    {
        len = nums.length;
        for(int i=0; i<len; i++) targetOr |= nums[i];
        dp = new Integer[len][targetOr+1];
        return generateSubsetsAndRes(nums, 0, 0);
    }
}