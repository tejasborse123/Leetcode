class Solution 
{
    public boolean areSentencesSimilar(String sentence1, String sentence2) 
    {
        int len1 = sentence1.length();
        int len2 = sentence2.length();

        if(len1 == len2) return sentence1.equals(sentence2);

        if(len1 > len2)
        {
            return areSentencesSimilar(sentence2, sentence1);
        }

        String smallerWords[] = sentence1.split(" ");
        String largerWords[] = sentence2.split(" ");

        int start = 0;
        int end1 = smallerWords.length-1;
        int end2 = largerWords.length-1;

        while(start<=end1 && smallerWords[start].equals(largerWords[start])) start++;
        while(start<=end1 && smallerWords[end1].equals(largerWords[end2])) 
        {
            end1--; end2--;
        }

        return (start>end1);
    }
}