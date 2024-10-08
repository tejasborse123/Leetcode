// Solution 1 : Using Stack.

class Solution 
{
    public int minSwaps(String s) 
    {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(stack.isEmpty()) stack.push(ch);
            else if(stack.peek() == '[' && ch == ']') stack.pop();
            else stack.push(ch);
        }

        int totalClosed = stack.size()/2;
        int Swaps = ++totalClosed / 2;

        return Swaps;
    }
}


// Solution 2 : Using Array as Custom Stack.

class Solution 
{
    public int minSwaps(String s) 
    {
        char stack[] = new char[s.length()];
        int idx = -1;

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(idx == -1) stack[++idx] = ch;
            else if(stack[idx] == '[' && ch == ']') idx--;
            else stack[++idx] = ch;
        }

        int totalClosed = ++idx/2;
        int Swaps = ++totalClosed/2;

        return Swaps;
    }
}

// Solution 3 : Using 2 Variables and for loop

class Solution 
{
    public int minSwaps(String s) 
    {
        int open = 0;
        int close = 0;

        for(int i=0; i<s.length(); i++) 
        {
            int ch = s.charAt(i);

            if(ch == '[') open++;
            else if (open <= 0) close++;
            else if(ch != '[') open--;    
        }

        return (close+1)/2 ;
    }
}

// Solution 4 : Using getBytes Method.

class Solution 
{
    public int minSwaps(String s) 
    {
        int opening = 0;
        int unbalanced = 0;

        for (var c: s.getBytes()) 
        {
            if(c == '[') opening++;
            else if(opening > 0) opening--;
            else if (c != '[') unbalanced++;    
        }

        return (unbalanced+1) / 2;
    }
}