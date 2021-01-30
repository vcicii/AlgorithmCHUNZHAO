public class PostOrder {
    List<Integer> it = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root != null){
            for(Node node: root.children){
                this.postorder(node);
            }
            it.add(root.val);
        }
        return it;
    }
}
