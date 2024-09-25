// Approach 1 : Brute Force : Will give Time Limit Exceeded error TLE

class Solution 
{
    public int[] sumPrefixScores(String[] words) 
    {
        HashMap<String,Integer> freqMap = new HashMap<>();
        int answer[] = new int[words.length];

        for(String word : words)
        {
            StringBuilder curr = new StringBuilder();

            for(char ch : word.toCharArray())
            {
                curr.append(ch);
                freqMap.put(curr.toString(),freqMap.getOrDefault(curr.toString(),0)+1);
            }
        }

        for(int i=0;i<words.length; i++)
        {
            String word = words[i];
            StringBuilder curr = new StringBuilder();

            for(char ch : word.toCharArray())
            {
                curr.append(ch);
                answer[i] += freqMap.get(curr.toString());
            }
        }

        return answer;
    }
}


// Approach 2 : Using Trie


class Solution 
{
    static class TrieNode
    {
        TrieNode children[];
        int prefixCount;

        TrieNode()
        {
            children = new TrieNode[26];
            prefixCount = 0;
        }
    }

    public TrieNode root;

    public void insertIntoTrie(String word)
    {
        TrieNode temp = root;

        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null) temp.children[idx] = new TrieNode();
            temp = temp.children[idx];
            temp.prefixCount++;
        }
    }

    public int calculatePrefixScore(String word)
    {
        TrieNode temp = root;
        int Score = 0;

        for(char ch : word.toCharArray())
        {
            int idx = ch - 'a';
            temp = temp.children[idx];
            Score += temp.prefixCount;
        }

        return Score;
    }

    public int[] sumPrefixScores(String[] words) 
    {
        int answer[] = new int[words.length];
        root = new TrieNode();

        for(String word : words) insertIntoTrie(word);
        for(int i=0; i<words.length; i++) answer[i] = calculatePrefixScore(words[i]);

        return answer;
    }
}