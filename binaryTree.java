 
/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * binaryTree Class Definition
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class binaryTree
{
    private TreeNode root;
    
    /**
     * Insert data into binary tree
     * @param fName First name
     * @param lName Last name
     * @param phone Phone number
     * @param email Email address
     */
    public void insert (String fName, String lName, String phone, String email) {
        // AR - create entry object with params
        Entry newEntry = new Entry(fName, lName, phone, email);
        // AR - create hash with uppercase fName+lName
        String key = generateKey(fName,lName);
        if (this.root == null) {
            this.root = new TreeNode(key, newEntry);
            System.out.println("Added to BTree: " + fName + " " + lName);
        } else {
            root.insert(key, newEntry);
        }
    }
    
    /**
     * Remove entry from binary tree
     * @param fName
     * @param lName 
     */
    public void remove (String fName, String lName) {
        String key = generateKey(fName,lName);
        
        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeftChild = false;
        
        if (current == null) {
            // AR - Tree is empty
            System.out.println("Removal error: Tree is empty!");
        } else {
            // AR - loop through tree until current node is null or we find what we're looking for
            while (current != null && current.getKey().compareTo(key) != 0) {
                // AR - Set parent value to current, as we still haven't found what we're looking for
                parent = current;
                if (current.getKey().compareTo(key) > 0) {
                    current = current.getLeftChild();
                    isLeftChild = true;
                } else {
                    current = current.getRightChild();
                    isLeftChild = false;
                }
            }
            
            if (current == null) {
                // AR - Entry not found
                System.out.println("Removal error: " + fName + " " + lName + " not found");
            } else {
                // AR - Node is a leaf
                if (current.getLeftChild() == null && current.getRightChild() == null) {
                    if (current != root) {
                        if (isLeftChild)
                            parent.setLeftChild(null);
                        else
                            parent.setRightChild(null);
                    } else {
                        root = null;
                    }
                    System.out.println("Tree user removed: " + fName + " " + lName);
                } else if (current.getRightChild() == null) {
                    // AR - current only has a left child
                    if (current != root) {
                        if (isLeftChild) {
                            parent.setLeftChild(current.getLeftChild());
                        } else {
                            parent.setRightChild(current.getLeftChild());
                        }
                    } else {
                        root = current.getLeftChild();
                    }
                    System.out.println("Tree user removed: " + fName + " " + lName);
                } else if (current.getLeftChild() == null) {
                    // AR - current only has a right child
                    if (current != root) {
                        if (isLeftChild) {
                            parent.setLeftChild(current.getRightChild());
                        } else {
                            parent.setRightChild(current.getRightChild());
                        }
                    } else {
                        root = current.getRightChild();
                    }
                    System.out.println("Tree user removed: " + fName + " " + lName);
                } else {
                    // AR - current has 2 children
                    // AR - Find successor
                    // AR -- From right child of current, go to left child until left child == null
                    TreeNode successorParent = current;
                    TreeNode successor = current.getRightChild();
                    while (successor.getLeftChild() != null) {
                        successorParent = successor;
                        successor = successor.getLeftChild();
                    }
                    // AR - unlink the successor from it's parent
                    if (successor.getRightChild() == null) {
                        successorParent.setLeftChild(null);
                    } else {
                        // AR - if it exists, move the successor's right child to the successor's parent's left
                        successorParent.setLeftChild(successor.getRightChild());
                    }
                    // AR - link successor in place of the current node unless it's the root as root has no parent
                    if (current != root) {
                        if (isLeftChild) {
                            parent.setLeftChild(successor);
                        } else {
                            parent.setRightChild(successor);
                        }
                    } else {
                        root = successor;
                    }
                    // AR - finish off moving the successor into place
                    successor.setLeftChild(current.getLeftChild());
                    successor.setRightChild(current.getRightChild());
                    System.out.println("Tree user removed: " + fName + " " + lName);
                }
            }
        }
    }
    
    /**
     * Lookup entry in binary tree 
     * @param fName
     * @param lName 
     */
    public void lookup (String fName, String lName) {
        String key = generateKey(fName,lName);
        TreeNode node = null;
        // AR - Check for empty tree
        if (root != null)
            node = root.find(key);
        if (node != null) {
            System.out.println("BTree Lookup successful:");
            node.getValue().displayEntry();
        } else {
            System.out.println("BTree Lookup failed: No such user (" + fName + " " + lName +")");
        }
    }
    
    /**
     * Creates key from fName and lName
     * @param fName
     * @param lName
     * @return key
     */
    private String generateKey(String fName, String lName) {
        return fName.toUpperCase()+lName.toUpperCase();
    }
    
    /**
     * Display root of a tree and it's 0-2 children
     * 
     */
    public void displayTree() {
        if (root != null) {
            System.out.println("Root: " + root.getKey());
            if (root.getLeftChild() != null)
                System.out.println("Left child: " + root.getLeftChild().getKey());
            if (root.getRightChild() != null)
                System.out.println("Right child:" + root.getRightChild().getKey());
        } else {
            System.out.println("Tree is empty");
        }
    }
    /**
     * Display a node and it's 0-2 children
     * @param fName
     * @param lName 
     */
    public void displayTree(String fName, String lName) {
        TreeNode node = root.find(this.generateKey(fName, lName));
        if (node != null) {
            System.out.println("Root: " + node.getKey());
            if (node.getLeftChild() != null)
                System.out.println("Left child: " + node.getLeftChild().getKey());
            if (node.getRightChild() != null)
                System.out.println("Right child: " + node.getRightChild().getKey());
        } else {
            System.out.println("Tree is empty");
        }
    }
    
}
