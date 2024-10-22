class Solution 
{
    public long kthLargestLevelSum(TreeNode root, int k) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            long currSum = 0l;

            for(int i=0; i<size; i++)
            {
                TreeNode curr = queue.poll();

                currSum += curr.val;

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }

            pq.offer(currSum);

            if(pq.size() > k) pq.poll();
        }

        return (pq.size() < k) ? -1 : pq.peek();
    }
}