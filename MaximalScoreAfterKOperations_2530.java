class Solution 
{
    public long maxKelements(int[] nums, int k) 
    {
        long Score = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) queue.offer((long)nums[i]);

        for(int idx=0; idx<k; idx++)
        {
            long currNum = queue.poll();
            Score += currNum;
            queue.offer((long) Math.ceil(currNum/3.0));
        }

        return Score;
    }
}