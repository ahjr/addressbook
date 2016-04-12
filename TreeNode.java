 

/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * TreeNode Class Definition
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class TreeNode {
    private final String key;
    private final Entry value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(String key, Entry value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Entry getValue() {
        return value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public TreeNode find (String key) {
        // AR - Compare given key to this node's key
        if (this.key.compareTo(key) == 0)
            // AR - If 0, found it
            return this;
//        System.out.println(this.key + " compare to " + key + " equals " + this.key.compareTo(key));
        if (this.key.compareTo(key) > 0 && leftChild != null ) {
            // AR - if given key is less than this node's key, it'll be to the left
            return leftChild.find(key);
        }
        if (rightChild != null)
            // AR - if given key is greater than this node's key, it'll be to the right
            return rightChild.find(key);
        return null;
    }
    
    public void insert (String key, Entry value) {
        // AR - if the key is greater than the key for the current node...
        if (this.key.compareTo(key) <= 0) {
            // AR - ...and the rightChild of the current node is empty, stick in our k/v pair
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(key, value);
                System.out.println("Added to BTree: " + value.getfName() + " " + value.getlName());
            // AR - otherwise, keep moving down to the right
            } else {
                this.rightChild.insert(key, value);
            }
        // AR - otherwise, move down to the left
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(key,value);
                System.out.println("Added to BTree: " + value.getfName() + " " + value.getlName());
            } else {
                this.leftChild.insert(key, value);
            }
        }
    }
}
