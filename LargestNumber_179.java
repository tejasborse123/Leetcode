// SOLUTION : 1


class Solution 
{
    public String largestNumber(int[] nums) 
    {
        int n = nums.length;
        String arr[] = new String[n];

        for(int i=0; i<n; i++) arr[i] = Integer.toString(nums[i]);

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String num1, String num2)
            {
                String firstNum = num1 + num2;
                String secondNum = num2 + num1;

                return secondNum.compareTo(firstNum);
            }

        });

        StringBuilder largestNum = new StringBuilder();

        if(arr[0].equals("0")) return "0";

        for(int i=0; i<n; i++) 
        {
            largestNum.append(arr[i]);
        }

        return largestNum.toString(); 
    }
}



// SOLUTION : 2



class Solution 
{
    public String largestNumber(int[] nums) 
    {
        PriorityQueue<String> maxHeap = new PriorityQueue<>(new Comparator<String>() 
        {
            @Override
            public int compare(String first, String second)
            {
                return (second+first).compareTo(first+second);
            }
        });

        int totalLength = 0;

        for(int num : nums)
        {
            String strNum = Integer.toString(num);
            totalLength += strNum.length();
            maxHeap.offer(strNum);
        }

        StringBuilder result = new StringBuilder(totalLength);

        while(!maxHeap.isEmpty())
        {
            result.append(maxHeap.poll());
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}

