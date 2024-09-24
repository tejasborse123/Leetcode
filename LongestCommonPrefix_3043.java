// Using String 


class Solution 
{
    class TrieNode
    {
        TrieNode children[];
        boolean isEndOfWord;

        TrieNode()
        {
            children = new TrieNode[10];
            isEndOfWord = false;
        }
    }

    public TrieNode root;

    public void insertIntoTrie(String word)
    {
        TrieNode temp = root;

        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - '0';
            if(temp.children[idx] == null) temp.children[idx] = new TrieNode();
            temp = temp.children[idx];
        } 
        temp.isEndOfWord = true;
    }

    public int lengthOfPrefixInTrie(String word)
    {
        TrieNode temp = root;
        int length = 0;

        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - '0';
            if(temp.children[idx] != null) length++;
            else return length;
            temp = temp.children[idx];
        } 

        return word.length();
    }
   
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        root = new TrieNode();

        int longestPrefix = 0;
        for(int num : arr1) insertIntoTrie(Integer.toString(num));

        for(int num : arr2)
        longestPrefix = Math.max(longestPrefix, lengthOfPrefixInTrie(Integer.toString(num)));

        return longestPrefix;
    }
}


// Using Integer Trie



class Solution 
{
    class TrieNode
    {
        TrieNode children[];
        boolean isEndOfWord;

        TrieNode()
        {
            children = new TrieNode[10];
            isEndOfWord = false;
        }
    }

    public TrieNode root;

    public void insertIntoTrie(int num)
    {
        TrieNode temp = root;
        int divisor = (int) Math.pow(10, (int)Math.log10(num));

        while(divisor > 0)
        {
            int digit = num / divisor;
            num %= divisor;
            divisor /= 10;

            if(temp.children[digit] == null) temp.children[digit] = new TrieNode();
            temp = temp.children[digit];
        } 
        temp.isEndOfWord = true;
    }

    public int lengthOfPrefixInTrie(int num)
    {
        TrieNode temp = root;
        int length = 0;
        int divisor = (int) Math.pow(10, (int)Math.log10(num));

        while(divisor > 0)
        {
            int digit = num / divisor;
            num %= divisor;
            divisor /= 10;

            if(temp.children[digit] != null) length++;
            else return length;
            temp = temp.children[digit];
        } 

        return length;
    }
   
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        root = new TrieNode();
        
        int longestPrefix = 0;
        for(int num : arr1) insertIntoTrie(num);

        for(int num : arr2)
        longestPrefix = Math.max(longestPrefix, lengthOfPrefixInTrie(num));

        return longestPrefix;
    }
}

