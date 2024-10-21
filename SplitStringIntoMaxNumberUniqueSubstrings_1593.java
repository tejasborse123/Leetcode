class Solution 
{
    int maxCount;
    int len;
    public void backTrack(String s, HashSet<String> set, int idx)
    {
        if(idx == len)
        {
            maxCount = Math.max(maxCount,set.size());
            return;
        }

        for(int i=idx; i<len; i++)
        {
            String subStr = s.substring(idx, i+1);

            if(!set.contains(subStr))
            {
                set.add(subStr);
                backTrack(s,set,i+1);
                set.remove(subStr);
            }
        }
    }
    public int maxUniqueSplit(String s) 
    {
        maxCount = 0;
        len = s.length();
        HashSet<String> set = new HashSet<>();
        backTrack(s,set,0);
        return maxCount;
    }
}