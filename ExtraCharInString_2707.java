class Solution 
{
    public static HashSet<String> set;
    int len;
    public static int dp[];

    public int getExtraCount(String s, int idx)
    {
        if(idx == len) return 0;

        if(dp[idx] != -1) return dp[idx];

        StringBuilder result = new StringBuilder();
        int extraCharCount = Integer.MAX_VALUE;

        for(int i=idx; i<len; i++)
        {
            result.append(s.charAt(i));
            int extraChar = 0;
            if(!set.contains(result.toString())) extraChar = result.length();
            int currExtra = getExtraCount(s,i+1);
            extraCharCount = Math.min(extraCharCount,extraChar + currExtra);
        }

        return dp[idx] = extraCharCount;
    }

    public int minExtraChar(String s, String[] dictionary) 
    {
        dp = new int[50];
        Arrays.fill(dp,-1);
        len = s.length();
        set = new HashSet<>();
        for(String word : dictionary)  set.add(word);
        return getExtraCount(s,0);
    }
}