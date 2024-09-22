class Solution 
{
    private int countSteps(int n, long prefix1, long prefix2)
    {
        int steps = 0;

        while(prefix1 <= n)
        {
            steps += Math.min(n+1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }

        return steps;
    }
    public int findKthNumber(int n, int k) 
    {
        int currNum = 1;
        k--;

        while(k > 0)
        {
            int steps = countSteps(n, currNum, currNum+1);
            if(steps <= k)
            {
                currNum++;
                k -= steps;
            }
            else
            {
                currNum *= 10;
                k--;
            }
        }

        return currNum;
    }
}