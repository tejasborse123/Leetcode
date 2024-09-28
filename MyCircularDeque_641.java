// Solution 1 : Using Array

class MyCircularDeque 
{
    int cirArray[];
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) 
    {
        cirArray = new int[k];
        front = 0;
        rear = k-1;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) 
    {
        if(isFull()) return false;

        front =  (front - 1 + capacity) % capacity;
        cirArray[front] = value;
        size++;

        return true;
    }
    
    public boolean insertLast(int value) 
    {
        if(isFull()) return false;

        rear =  (rear + 1) % capacity;
        cirArray[rear] = value;
        size++;

        return true;
    }
    
    public boolean deleteFront() 
    {
        if(size <= 0) return false;

        front = (front+1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() 
    {
        if(size <= 0) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() 
    {
        if(size <= 0) return -1;
        return cirArray[front];
    }
    
    public int getRear() 
    {
        if(size <= 0) return -1;
        return cirArray[rear];
    }
    
    public boolean isEmpty() 
    {
        return (size == 0);
    }
    
    public boolean isFull() 
    {
        return (size == capacity);
    }
}


// Solution 2 : Using LinkedList
 
 class MyCircularDeque 
{
    LinkedList<Integer> list;
    int size;
    int k;

    public MyCircularDeque(int k) 
    {
        list = new LinkedList<>();
        size = 0;
        this.k=k;
    }
    
    public boolean insertFront(int value) 
    {
        if(size < k)
        {
            list.addFirst(value);
            size++;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) 
    {
        if(size < k)
        {
            list.add(value);
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() 
    {
        if(size <= 0) return false;
        list.removeFirst();
        size--;
        return true;
    }
    
    public boolean deleteLast() 
    {
        if(size <= 0) return false;
        list.removeLast();
        size--;
        return true;
    }
    
    public int getFront() 
    {
        if(size==0) return -1;
        return list.get(0);
    }
    
    public int getRear() 
    {
        if(size==0) return -1;
        return list.get(size-1);
    }
    
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    public boolean isFull() 
    {
        return size == k;
    }
}