// Iterative Approach 


class Solution 
{
    public List<Integer> lexicalOrder(int n) 
    {
        List<Integer> result = new ArrayList<>();
        int currNum = 1;

        for(int i=1; i<=n; i++)
        {
            result.add(currNum);

            if(currNum*10 <= n)
            {
                currNum *= 10; 
            }
            else
            {
                while(currNum%10 == 9 || currNum == n) currNum /= 10;
                currNum++;
            }
        }

        return result;
    }
}




// Using DFS



class Solution 
{
    List<Integer> result;

    public void dfs(int curr, int n) {
        if (curr > n) return;

        result.add(curr);  

        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) break;  
            dfs(next, n);  
        }
    }

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();  

        for (int i = 1; i <= 9; i++) {
            if (i > n) break;  
            dfs(i, n);  
        }

        return result;  
    }
}







// Using Trie Data Structure




class Solution 
{
    static class Node
    {
        Node children[];
        boolean endOfWord;

        public Node()
        {
            this.children = new Node[10];
            Arrays.fill(children,null);
            this.endOfWord = false;
        }
    }

    public Node root = new Node();

    public void insertInTrie(String word)
    {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - '0';
            
            if(curr.children[idx] == null)
            {
                curr.children[idx] = new Node();
            }
            
            if(i == word.length()-1)
            {
                curr.children[idx].endOfWord = true;
            }
            
            curr = curr.children[idx];
        }
    }
    
        
    List<Integer> result;

    public void dfs(Node curr, String path)
    {
        if(curr == null) return;

        if(curr.endOfWord)  result.add(Integer.parseInt(path));

        for(int i = 0; i < 10; i++)
        {
            if(curr.children[i] != null)    dfs(curr.children[i], path + i);
        }
    }

    public List<Integer> lexicalOrder(int n) 
    {
        result = new ArrayList<>();
        for(int i=1; i<=n; i++) insertInTrie(String.valueOf(i));
        dfs(root,"");
        return result;
    }
}





// 