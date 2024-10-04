// Solution 1 : Using HashMap

class Solution 
{
    public long dividePlayers(int[] skill) 
    {
        int n = skill.length;
        int groupsToMake = n/2;
        int totalSum = 0;
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            int currNum = skill[i];

            totalSum += currNum;
            freqMap.put(currNum, freqMap.getOrDefault(currNum,0) + 1);
        }

        if(totalSum % groupsToMake != 0) return -1;
        int sumReqPerGrp = totalSum / groupsToMake;

        long product = 0;

        for(int num : skill)
        {
            if(freqMap.get(num) == 0) continue;

            int toSearch = sumReqPerGrp - num;

            if (!freqMap.containsKey(toSearch) || freqMap.get(toSearch) == 0) return -1;

            product += (num * toSearch);
            freqMap.put(num, freqMap.get(num) - 1);
            freqMap.put(toSearch, freqMap.get(toSearch) - 1);
        }
        
        return product;
    }
}



// Solution 2 : Using Array -- Optimized


class Solution 
{
    public long dividePlayers(int[] skill) 
    {
        int n = skill.length;
        int groupsToMake = n/2;
        int totalSum = 0;
        int freqMap[] = new int[1001];

        for(int i=0; i<n; i++)
        {
            int currNum = skill[i];
            totalSum += currNum;
            freqMap[currNum]++;
        }

        if(totalSum % groupsToMake != 0) return -1;
        int sumReqPerGrp = totalSum / groupsToMake;

        long product = 0;

        for(int num : skill)
        {
            if(freqMap[num] == 0) continue;
			
            int toSearch = sumReqPerGrp - num;

            if(freqMap[toSearch] == 0) return -1;

            product += (num * toSearch);
            freqMap[num]--;
            freqMap[toSearch]--;
        }
        
        return product;
    }
}

