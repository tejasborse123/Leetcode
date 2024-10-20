class Solution 
{
    public boolean parseBoolExpr(String expression) 
    {
        Stack<Character> stack = new Stack<>();
        int len = expression.length();

        for(int i=0; i<len; i++)
        {
            char ch = expression.charAt(i);

            if(ch == ',') continue;

            if(ch == ')')
            {
                List<Character> ans = new ArrayList<>();
                boolean isTruePresent = false;
                boolean isFalsePresent = false;

                while(stack.peek() != '(')
                {
                    char currChar = stack.pop();
                    if(currChar == 't') isTruePresent = true;
                    if(currChar == 'f') isFalsePresent = true;
                    ans.add(currChar);
                }
                stack.pop();
                char op = stack.pop();

                if(op == '!') stack.push((ans.get(0) == 't') ? 'f' : 't');
                else if(op == '|') stack.push( isTruePresent ? 't' : 'f' );
                else if(op == '&') stack.push( isFalsePresent ? 'f' : 't');
            }
            else
            {
                stack.push(ch);
            }
        }

        return stack.peek() == 't';
    }
}