// Solution 1 : Using TreeMap and ArrayList

class MyCalendarTwo 
{
    List<int[]> bookingList;
    TreeMap<Integer,Integer> overlappedMap;

    public MyCalendarTwo() 
    {
        bookingList = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) 
    {
        Integer prevVal = overlappedMap.lowerKey(end);

        if(prevVal != null && start <= overlappedMap.get(prevVal)-1) return false;

        for(int booking[] : bookingList)
        {
            int commonStart = Math.max(booking[0], start);
            int commonEnd = Math.min(booking[1], end);

            if(commonStart < commonEnd)
            {
                overlappedMap.put(commonStart,commonEnd);
            }
        }

        bookingList.add(new int[]{start,end});
        return true;
    }
}


// Sweep Line Algorithm : Will help in case of k simultaneous bookings.

class MyCalendarTwo 
{
    TreeMap<Integer,Integer> bookings;
    int maxAllowed;

    public MyCalendarTwo() 
    {
        bookings = new TreeMap<>();
        maxAllowed = 2;
    }
    
    public boolean book(int start, int end) 
    {
        bookings.put(start,bookings.getOrDefault(start,0)+1);
        bookings.put(end,bookings.getOrDefault(end,0)-1);

        int overlappedCount = 0;

        for(Map.Entry<Integer,Integer> entry : bookings.entrySet())
        {
            overlappedCount += entry.getValue();

            if(overlappedCount > maxAllowed)
            {
                bookings.put(start,bookings.getOrDefault(start,0)-1);
                bookings.put(end,bookings.getOrDefault(end,0)+1);

                if(bookings.get(start) == 0) bookings.remove(start); // Optional
                if(bookings.get(end) == 0) bookings.remove(end);     // Optional 

                return false;
            }
        } 
        return true;
    }
}
