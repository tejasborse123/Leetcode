class Solution 
{
    public String makeFancyString(String s) 
    {
        StringBuilder sb = new StringBuilder();
        char prevChar = s.charAt(0);
        int consecutive = 0;

        for(char currChar : s.toCharArray())
        {
            if(prevChar == currChar) consecutive++;
            else consecutive = 1;
            prevChar = currChar;
            if(consecutive < 3) sb.append(currChar);
        }

        return sb.toString();
    }
}