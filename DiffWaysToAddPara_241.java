// Recursive Solution :

class Solution 
{
    public List<Integer> diffWaysToCompute(String expression) 
    {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<expression.length(); i++)
        {
            char currChar = expression.charAt(i);

            if(currChar == '+' || currChar == '*' || currChar == '-')
            {
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> leftAns = diffWaysToCompute(left);
                List<Integer> rightAns = diffWaysToCompute(right);

                for(int x : leftAns)
                {
                    for(int y : rightAns)
                    {
                        if(currChar == '+')
                        {
                            result.add(x+y);
                        }
                        else if(currChar == '-')
                        {
                            result.add(x-y);
                        }
                        else
                        {
                            result.add(x*y);
                        }
                    }
                }
            }
        }

        if(result.size() == 0) result.add(Integer.parseInt(expression));
        return result;
    }
}




// Optimize Solution : After Using Dynamic Programming



class Solution 
{
    Map<String, List<Integer>> dp = new HashMap<>(); 

    public List<Integer> diffWaysToCompute(String expression) 
    {
        if(dp.containsKey(expression)) return dp.get(expression);

        ArrayList<Integer> result = new ArrayList<>();
        int n = expression.length();

        for(int i=0; i<n; i++)
        {
            char currChar = expression.charAt(i);

            if(currChar == '+' || currChar == '*' || currChar == '-')
            {
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> leftAns = diffWaysToCompute(left);
                List<Integer> rightAns = diffWaysToCompute(right);

                for(int x : leftAns)
                {
                    for(int y : rightAns)
                    {
                        if(currChar == '+')
                        {
                            result.add(x+y);
                        }
                        else if(currChar == '-')
                        {
                            result.add(x-y);
                        }
                        else
                        {
                            result.add(x*y);
                        }
                    }
                }
            }
        }

        if(result.isEmpty()) result.add(Integer.parseInt(expression));
        dp.put(expression,result);
        
        return result;
    }
} 