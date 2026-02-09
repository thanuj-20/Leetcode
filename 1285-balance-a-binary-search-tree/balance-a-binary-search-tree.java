class Solution {
    List<Integer> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, arr.size() - 1);
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        arr.add(node.val);
        inorder(node.right);
    }
    private TreeNode build(int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(arr.get(m));
        node.left = build(l, m - 1);
        node.right = build(m + 1, r);
        return node;
    }
}
