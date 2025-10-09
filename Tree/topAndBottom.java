
// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/


// In top view, we only keep the first node that appears in each vertical column when traversing level by level (BFS).

// We're saying:
// 👉 "If we haven’t added a node for this column before, then add this one."

// This ensures that:

// The first node encountered in BFS for a particular column is used.

// Any further nodes in that column are ignored (because they are lower down and hidden from top view).

// Time: O(n log n)

// Each insertion in TreeMap takes O(log n)
 *     }

// Space: O(n)

// Map + Queue for BFS

class Solution {
    static class Pair{
        int col;
        Node node;
        
        Pair(int col, Node node){
            this.col = col;
            this.node = node;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList <Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Map <Integer, Integer> map = new TreeMap<>();
        
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int coll = q.peek().col;
            Node temp = q.peek().node;
            q.remove();
            
            if(map.get(coll) == null) map.put(coll, temp.data);
            if(temp.left != null) q.add(new Pair(coll-1, temp.left));
            if(temp.right != null) q.add(new Pair(coll+1, temp.right));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}


//Bottom View

// Overwrite the value for every column — don’t check if it already exists in the map.


// in place of this
//             if(map.get(coll) == null) map.put(coll, temp.data);
// Do
//     map.put(coll, temp.data); // for bottom view

