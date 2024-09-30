// Approach 1 : Using Array

// Time Complexity Analysis :
// For CustomStack(int maxSize) : O(1)
// For push(int x) : O(1)
// For pop() : O(1)
// For increment(int k, int val) : O(k) --------> where k = Math.min(k,top) 

// Space Complexity : O(n)

class CustomStack 
{
    int stack[];
    int top;
    int capacity;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
        capacity = maxSize;
    }
    
    public void push(int x) 
    {
        if(top+1 < capacity)
        {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() 
    {
        if(top == -1) return -1;
        return stack[top--];
    }
    
    public void increment(int k, int val) 
    {
        for(int i=0; i<k && i<=top; i++)
        {
            stack[i] += val; 
        }
    }
}







// Approach 2 : Using Lazy Propogation

// Time Complecity Analysis :
// For CustomStack(int maxSize) : O(1)
// For push(int x) : O(1)
// For pop() : O(1)
// For increment(int k, int val) : O(1) 

// Space Complexity : O(2n) => O(n) 

class CustomStack 
{
    int stack[];
    int operation[];
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operation = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) 
    {
        if(top+1 < stack.length)
        {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() 
    {
        if(top == -1) return -1;
        if(top > 0)
        {
            operation[top-1] += operation[top];
        }
        int val = operation[top];
        operation[top] = 0;

        return val + stack[top--] ;
    }
    
    public void increment(int k, int val) 
    {
        if(top >= 0)
        {
            int num = Math.min(k-1, top);
            operation[num] += val;
        }
    }
}

