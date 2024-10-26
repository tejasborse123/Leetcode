class Solution 
{
    int maxNum;

    public void calculateLeftHeight(TreeNode root, int left[], int currMax)
    {
        if(root == null) return;
        left[root.val] = maxNum;
        maxNum = Math.max(maxNum,currMax);
        calculateLeftHeight(root.left, left, currMax+1);
        calculateLeftHeight(root.right, left, currMax+1);
    }
    
    public void calculateRightHeight(TreeNode root, int right[], int currMax)
    {
        if(root == null) return;
        right[root.val] = maxNum;
        maxNum = Math.max(maxNum,currMax);
        calculateRightHeight(root.right, right, currMax+1);
        calculateRightHeight(root.left, right, currMax+1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) 
    {
        int left[] = new int[100001]; 
        int right[] = new int[100001]; 

        maxNum = 0;
        calculateLeftHeight(root,left,0);
        maxNum = 0;
        calculateRightHeight(root,right,0);
        
        for(int i=0; i<queries.length; i++)
        {
            int currNum = queries[i];
            queries[i] = Math.max(left[currNum] , right[currNum]);
        }

        return queries;
    }
}