class Solution 
{
    public long minimumSteps(String s) 
    {
        int lastPtr = 0;
        long swapCount = 0;

        for(int currPtr=0; currPtr<s.length(); currPtr++)
        {
            if(s.charAt(currPtr) == '0')
            {
                swapCount += (currPtr - lastPtr);
                lastPtr++;
            }
        }

        return swapCount;
    }
}