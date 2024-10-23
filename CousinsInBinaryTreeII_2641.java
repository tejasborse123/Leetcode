// Solution 1 : Using 2 Pass of BFS

class Solution 
{
    public TreeNode replaceValueInTree(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> levelSum = new ArrayList<>();
        root.val = 0;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int currSum = 0;

            for(int i=0; i<size; i++)
            {
                TreeNode curr = queue.poll();
                currSum += curr.val;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            levelSum.add(currSum);
        }

        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i=0; i<size; i++)
            {   
                int currSum = 0;
                TreeNode curr = queue.poll();
                
                if(curr.left != null) currSum += curr.left.val;
                if(curr.right != null) currSum += curr.right.val;

                if(curr.left != null) 
                {
                    curr.left.val = levelSum.get(level+1) - currSum;
                    queue.offer(curr.left);
                }
                if(curr.right != null)
                {
                    curr.right.val = levelSum.get(level+1) - currSum;
                    queue.offer(curr.right);
                }
            }
            level++;
        }

        return root;        
    }
}

// Solution 2 : Using 1 single Pass of BFS

class Solution 
{
    public TreeNode replaceValueInTree(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int levelSum = 0;
            List<TreeNode> nodes = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = queue.poll();
                nodes.add(curr);

                if(curr.left != null) 
                {
                    queue.offer(curr.left);
                    levelSum += curr.left.val;
                }
                if(curr.right != null) 
                {
                    queue.offer(curr.right);
                    levelSum += curr.right.val;
                }
            }

            for(TreeNode node : nodes)
            {
                int siblingSum = 0;
                if(node.left != null) siblingSum += node.left.val;
                if(node.right != null) siblingSum += node.right.val;

                if(node.left != null) node.left.val = levelSum - siblingSum;
                if(node.right != null) node.right.val = levelSum - siblingSum;
            }
        }

        return root;        
    }
}

