class Solution 
{
    public boolean isDistributionPossible(int quantities[], int maxProduct, int stores)
    {
        int storeCount = 0;

        for(int i=0; i<quantities.length; i++)
        {
            storeCount += quantities[i]/maxProduct;
            if(quantities[i]%maxProduct != 0) storeCount++;

            if(storeCount > stores) return false;
        }

        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) 
    {
        int len = quantities.length;
        int start = 1;
        int end = Integer.MIN_VALUE;
        int res = -1;

        for(int i=0; i<len; i++) if(end < quantities[i]) end = quantities[i];

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(isDistributionPossible(quantities, mid, n))
            {
                res = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }

        return res;
    }
}