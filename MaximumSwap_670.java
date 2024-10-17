class Solution 
{
    public int maximumSwap(int num) 
    {
        StringBuilder number = new StringBuilder(String.valueOf(num));
        int len = number.length();
        if(len <= 1) return num;
        int last[] = new int[10];

        for(int i=0; i<len; i++) last[number.charAt(i) - '0'] = i;

        for(int i=0; i<len; i++)
        {
            int currNum = number.charAt(i) - '0';

            for(int d=9; d>currNum; d--)
            {
                if(last[d] > i)
                {
                    char temp = number.charAt(i);
                    number.setCharAt(i, number.charAt(last[d]));
                    number.setCharAt(last[d], temp);

                    return Integer.parseInt(number.toString());
                }
            }
        }  

        return num; 
    }
}