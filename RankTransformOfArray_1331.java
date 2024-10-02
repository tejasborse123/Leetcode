// Solution 1 :

class Solution 
{
    public int[] arrayRankTransform(int[] arr) 
    {
        int len = arr.length;
        int sortedCopy[] = Arrays.copyOf(arr,len);
        Arrays.sort(sortedCopy);

        HashMap<Integer,Integer> rankMap = new HashMap<>();
        int rank = 0;
        int prev = Integer.MAX_VALUE;

        for(int i=0; i<len; i++)
        {
            if(prev != sortedCopy[i]) rank++;
            prev = sortedCopy[i];
            rankMap.put(prev,rank);
        }

        for(int i=0; i<len; i++) sortedCopy[i] = rankMap.get(arr[i]);

        return sortedCopy;
    }
}

// Solution 2 :

class Solution 
{
	public int[] arrayRankTransform(int[] arr) 
	{
		int len = arr.length;
		HashMap<Integer,Integer> rankMap = new HashMap<>();

		int sortedArr[] = Arrays.copyOf(arr,len);
		Arrays.sort(sortedArr);

		int rank = 1;

		for(int i=0; i<len; i++)
		{
		 if(i>0 && sortedArr[i] > sortedArr[i-1]) rank++;
		 rankMap.put(sortedArr[i], rank);
		}

		for(int i=0; i<len; i++)
		{
		 arr[i] = rankMap.get(arr[i]);
		}

		return arr;
	}
}