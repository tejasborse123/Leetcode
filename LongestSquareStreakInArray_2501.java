// Solution 1 : Using HashMap and Sorting

class Solution 
{
    public int longestSquareStreak(int[] nums) 
    {
        Arrays.sort(nums);
        int maxCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            int currNum = nums[i];
            int root = (int)Math.sqrt(currNum);

            if(root*root == currNum && map.containsKey(root))
            {
                int freq = map.get(root)+1;
                map.put(currNum, freq);
                maxCount = Math.max(maxCount, freq);
            }
            else
            {
                map.put(currNum, 1);
            }
        }

        return (maxCount > 1) ? maxCount : -1;
    }
}




// Solution 2 : Using Array of Max Size and Sorting

class Solution 
{
    public int longestSquareStreak(int[] nums) 
    {
        Arrays.sort(nums);
        int Counting[] = new int[100001];
        for(int i=0; i<nums.length; i++) Counting[nums[i]]++;
        int maxCount = 0;

        for(int i=0; i<nums.length; i++)
        {
            int currNum = nums[i];
            int root = (int)Math.sqrt(currNum);

            if(root*root == currNum && Counting[root] > 0)
            {
                int freq = Counting[root]+1;
                Counting[currNum] = freq;
                maxCount = Math.max(maxCount, freq);
            }
            else
            {
                Counting[currNum] = 1;
            }
        }

        return (maxCount > 1) ? maxCount : -1;
    }
}




// Solution 3 : Using Array of Max Size without sorting

class Solution 
{
    public int longestSquareStreak(int[] nums) 
    {
        int Counting[] = new int[100001];
        for(int i=0; i<nums.length; i++) Counting[nums[i]]++;
        int maxCount = 0;

        for(int i=0; i<100001; i++)
        {
            if(Counting[i] > 0)
            {
                int currNum = i;
                int currStreak = 0;

                while(currNum <= 100000 && Counting[currNum] > 0)
                {
                    Counting[currNum] = 0;
                    currStreak++;
                    if((long) currNum*currNum > 100000) break;
                    currNum *= currNum;
                }

                maxCount = Math.max(maxCount, currStreak);
            }
        }

        return (maxCount > 1) ? maxCount : -1;
    }
}











