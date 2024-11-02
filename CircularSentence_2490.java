// Solution 1 : Using Split() function and extra space

class Solution 
{
    public boolean isCircularSentence(String sentence) 
    {
        String words[] = sentence.split(" ");
        String prev = words[0];
        int len = words.length;

        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)) return false;
        if(len == 1) return true;

        for(int i=1; i<len; i++)
        {
            String currWord = words[i];
            int n = prev.length();
            if(prev.charAt(n-1) != currWord.charAt(0)) return false;
            prev = currWord;
        }

        return true;
    }
}

// Solution 2 : Using indexOf() function and no extra space


class Solution 
{
    public boolean isCircularSentence(String sentence) 
    {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)) return false;
        int idxOfSpace = sentence.indexOf(" ");
        if(idxOfSpace == -1) return true;

        while(idxOfSpace != -1) 
        {
            if(sentence.charAt(idxOfSpace - 1) != sentence.charAt(idxOfSpace + 1)) return false;
            idxOfSpace = sentence.indexOf(" ", idxOfSpace+1);
        }

        return true;
    }
}




