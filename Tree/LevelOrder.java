public class Solution{
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        Queue <Integer> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> levels = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levels.add(node.val);

                if(node.left != null){
                    queue.add(node.left.val);
                }

                if(node.right != null){
                    queue.add(node.right.val);
                }
            }

            ans.add(levels.get(levels.size()-1));
        }
    }
}