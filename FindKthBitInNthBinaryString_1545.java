class Solution 
{
    public char findKthBit(int n, int k) 
    {
        if(n == 1 || k == 1) return '0';
        
        StringBuilder ans = new StringBuilder();
        ans.append("0");

        for(int i=1; i<n; i++)
        {
            String reverse = new StringBuilder(ans).reverse().toString();
            ans.append("1");

            for(char ch : reverse.toCharArray())
            {
                char toAppend = (ch == '0') ? '1' : '0';
                ans.append(toAppend);
            }

            if(ans.length() > k) return ans.charAt(k-1);
        }

        return ans.charAt(k-1);
    }
}