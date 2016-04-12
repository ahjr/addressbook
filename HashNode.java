 

/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * Node Class Definition
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class HashNode {
    private String key;
    private Entry value;
    private HashNode nextNode;
    
    /**
     * Constructor of object Node
     * 
     */
    public HashNode(String key, Entry value) {
        setKey(key);
        setValue(value);
    }
    
    /**
     * Constructor of object Node with given nextNode
     */
    public HashNode(String key, Entry value, HashNode nextNode) {
        setKey(key);
        setValue(value);
        setNextNode(nextNode);
    }
    
    /**
     * Set Node key
     * @param key 
     */
    public void setKey (String key) {
        this.key = key;
    }
    
    /**
     * Set Node value
     * @param value Object of type Entry
     */
    public void setValue (Entry value) {
        this.value = value;
    }
    
    /**
     * Set next node
     * @param nextNode
     */
    public void setNextNode(HashNode nextNode) {
        this.nextNode = nextNode;
    }
    
    /**
     * Get this node's key
     * @return key
     */
    public String getKey () {
        return key;
    }
    
    /**
     * Get this node's value
     * @return object of type Entry
     */
    public Entry getValue () {
        return value;
    }
    
    /**
     * Get next node
     * @return object of type Node
     */
    public HashNode getNextNode() {
        return nextNode;
    }
}
