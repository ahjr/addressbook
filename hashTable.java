 
/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * hashTable Class Definition
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class hashTable {
    // AR - bucket - array of Nodes
    private final HashNode[] buckets = new HashNode[13];
    
    /**
     * Constructor for objects of type hashTable
     */
    public hashTable() {
    }
    
    /**
     * Insert data into hash table
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
        int bucketLoc = getBucket(key);
        // AR - put entry into bucket 
        if (buckets[bucketLoc] == null) {
            // AR - if bucket is empty, set bucket entry to newNode
            HashNode newNode = new HashNode(key, newEntry);
            buckets[bucketLoc] = newNode;
        } else {
            // AR - if bucket already has an entry, stick the new one in front of it in the chain
            HashNode firstNode = buckets[bucketLoc];
            HashNode newNode = new HashNode(key, newEntry, firstNode);
            buckets[bucketLoc] = newNode;
        }
        System.out.println("Added to Hash table: " + fName + " " + lName);
    }
    
    /**
     * Remove an entry from the hash table
     * @param fName First name
     * @param lName Last name
     */
    public void remove (String fName, String lName) {
        boolean found = false;
        String key = generateKey(fName,lName);
        int bucketLoc = getBucket(key);
        // AR - start at the beginning of the bucket linked list
        // AR - if it's empty, thisNode will be null
        HashNode thisNode = buckets[bucketLoc];
        HashNode prevNode = null;
        while (!found && thisNode != null) {
            // AR - compare this node's key entry with the key we're looking for
            if (thisNode.getKey().equals(key)) {
                // AR - found the node
                found = true;
                // AR - unlink it
                if (prevNode != null) {
                    // AR - if this wasn't the first node, set the previous node's nextNode pointer 
                    prevNode.setNextNode(thisNode.getNextNode());
                } else {
                    // AR - Make the next node the first node in the linked list
                    buckets[bucketLoc] = thisNode.getNextNode();
                }
                System.out.println("Hash User removed: " + fName + " " + lName);
            } else {
                // AR - move on to the next node in the linked list
                prevNode = thisNode;
                thisNode = thisNode.getNextNode();
            }
        }
    }
    
    /**
     * Lookup an entry given a first and last name
     * @param fName First name
     * @param lName Last name
     */
    public void lookup(String fName, String lName) {
        Entry currEntry = getEntry(fName, lName);
        if (currEntry == null) {
            // AR - user not found in hash table
            System.out.println("Hash Lookup failed: No such user (" + fName + " " + lName +")");
        } else {
            System.out.println("Hash Lookup successful:");
            currEntry.displayEntry();
        }
    }
    
    /**
     * Retrieve an entry from the hash table
     * @param fName First name
     * @param lName Last name
     * @return Entry object
     */
    private Entry getEntry (String fName, String lName) {
        String key = generateKey(fName,lName);
        int bucketLoc = getBucket(key);
        // AR - start at the top of the linked list.  value will be null if the bucket is empty
        HashNode thisNode = buckets[bucketLoc];
        while (thisNode != null) {
            // AR - while there are entries to check
            if (thisNode.getKey().equals(key)) {
                //AR - return as soon as we find what we're looking for
                return thisNode.getValue();
            } else {
                // AR - otherwise move to the next node
                thisNode = thisNode.getNextNode();
            }
        }
        // AR - if we haven't returned an entry by now, we didn't find what we are looking for
        return null;
    }
    
    /**
     * Get bucket from a last name and first name
     * @param key
     * @return int bucket number
     */
    private int getBucket(String key) {
        int hash = key.hashCode();
        // AR - Determine bucket with % 13
        int bucketLoc = hash % 13;
        // AR - Take care of negative hash values
        if (bucketLoc < 0) {
            bucketLoc = bucketLoc + 13;
        }
        return bucketLoc;
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
     * Dumps the whole hash table
     */
    public void displayHash() {
        for (int i=0; i<13; i++) {
            HashNode thisNode = buckets[i];
            if (thisNode != null) {
                System.out.println("Bucket " + i +" contains:");
            } else {
                System.out.println("Bucket " + i + " is empty");
            }
            while (thisNode != null) {
                Entry thisEntry = thisNode.getValue();
                System.out.println("  " + thisEntry.getfName() + " " + thisEntry.getlName());
                thisNode = thisNode.getNextNode();
            }
            
        }
    }

}
