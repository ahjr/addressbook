 

/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class AddressBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testHash();
        runHashTestCases();
        //addressHash.displayHash();
        //testBTree();
        //runBTreeTestCases();
    }
    
    private static void testHash() {
        hashTable addressHash = new hashTable();
        
        System.out.println("== Test Hash Insert ==");
        addressHash.insert("Test","User","123-456-7890","test@test.com");
        addressHash.displayHash();
        System.out.println("\n== Test Hash Lookup ==");
        addressHash.lookup("Test","User");
        System.out.println("\n== Test Hash Remove ==");
        addressHash.remove("Test","User");
        addressHash.displayHash();
    }
    
    private static void runHashTestCases() {
        // AR - Instantiate the hash table
        hashTable addressHash = new hashTable();
        
        // AR - Hash Table Test Cases
        System.out.println("=== Running Hash Table Test Cases ===");
        addressHash.insert("Bob","Smith","555-235-1111","bsmith@somewhere.com");
        addressHash.insert("Jane","Williams","555-235-1112","jw@something.com");
        addressHash.insert("Mohammed","al-Salam","555-235-1113","mas@someplace.com");
        addressHash.insert("Pat","Jones","555-235-1114","pjones@homesweethome.com");
        addressHash.insert("Billy","Kidd","555-235-1115","billy_the_kid@nowhere.com");
        addressHash.insert("H.","Houdini","555-235-1116","houdini@noplace.com");
        addressHash.insert("Jack","Jones","555-235-1117","jjones@hill.com");
        addressHash.insert("Jill","Jones","555-235-1118","jillj@hill.com");
        addressHash.insert("John","Doe","555-235-1119","jdoe@somedomain.com");
        addressHash.insert("Jane","Doe","555-235-1120","jdoe@somedomain.com");
        addressHash.lookup("Pat","Jones");
        addressHash.lookup("Billy","Kidd");
        addressHash.remove("John","Doe");
        addressHash.insert("Test","Case","555-235-1121","Test_Case@testcase.com");
        addressHash.insert("Nadezhda","Kanachekhovskaya","555-235-1122","dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        addressHash.insert("Jo","Wu","555-235-1123","wu@h.com");
        addressHash.insert("Millard","Fillmore","555-235-1124","millard@theactualwhitehouse.us");
        addressHash.insert("Bob","vanDyke","555-235-1125","vandyke@nodomain.com");
        addressHash.insert("Upside","Down","555-235-1126","upsidedown@rightsideup.com");
        addressHash.lookup("Nadezhda","Kanachekhovskaya");
        addressHash.lookup("Jack","Jones");
        addressHash.lookup("Nadezhda","Kanachekhovskaya");
        addressHash.remove("Jill","Jones");
        addressHash.lookup("John","Doe");
        addressHash.lookup("Jill","Jones");
        addressHash.lookup("John","Doe");
        addressHash.lookup("Nadezhda","Kanachekhovskaya");
        addressHash.lookup("Mallard","Fillmore"); 
    }
    
    private static void testBTree() {
        binaryTree addressTree = new binaryTree();
        
        System.out.println("== Test Hash Insert ==");
        addressTree.insert("Test","User","123-456-7890","test@test.com");
        addressTree.insert("West", "User", "123-456-7890", "west@test.com");
        addressTree.insert("Best", "User", "123-456-7890", "best@test.com");
        addressTree.insert("Aest", "User", "123-456-7890", "best@test.com");
        addressTree.displayTree();
        System.out.println("\n== Test Hash Lookup ==");
        addressTree.lookup("Test","User");
        System.out.println("\n== Test Hash Remove ==");
        addressTree.displayTree();
        addressTree.remove("Test", "User");
        addressTree.displayTree();
        addressTree.remove("Best", "User");
        addressTree.displayTree();
        addressTree.remove("West", "User");
        addressTree.displayTree();
        addressTree.remove("Aest", "User");
        addressTree.displayTree();
        addressTree.remove("Test", "User");
        addressTree.displayTree();
    }

    private static void runBTreeTestCases() {
        binaryTree addressTree = new binaryTree();
        
        System.out.println("=== Running Binary Tree Test Cases ===");
        addressTree.insert("Bob","Smith","555-235-1111","bsmith@somewhere.com");
        addressTree.insert("Jane","Williams","555-235-1112","jw@something.com");
        addressTree.insert("Mohammed","al-Salam","555-235-1113","mas@someplace.com");
        addressTree.insert("Pat","Jones","555-235-1114","pjones@homesweethome.com");
        addressTree.insert("Billy","Kidd","555-235-1115","billy_the_kid@nowhere.com");
        addressTree.insert("H.","Houdini","555-235-1116","houdini@noplace.com");
        addressTree.insert("Jack","Jones","555-235-1117","jjones@hill.com");
        addressTree.insert("Jill","Jones","555-235-1118","jillj@hill.com");
        addressTree.insert("John","Doe","555-235-1119","jdoe@somedomain.com");
        addressTree.insert("Jane","Doe","555-235-1120","jdoe@somedomain.com");
        addressTree.lookup("Pat","Jones");
        addressTree.lookup("Billy","Kidd");
        addressTree.remove("John","Doe");
        addressTree.insert("Test","Case","555-235-1121","Test_Case@testcase.com");
        addressTree.insert("Nadezhda","Kanachekhovskaya","555-235-1122","dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        addressTree.insert("Jo","Wu","555-235-1123","wu@h.com");
        addressTree.insert("Millard","Fillmore","555-235-1124","millard@theactualwhitehouse.us");
        addressTree.insert("Bob","vanDyke","555-235-1125","vandyke@nodomain.com");
        addressTree.insert("Upside","Down","555-235-1126","upsidedown@rightsideup.com");
        addressTree.lookup("Nadezhda","Kanachekhovskaya");
        addressTree.lookup("Jack","Jones");
        addressTree.lookup("Nadezhda","Kanachekhovskaya");
        addressTree.remove("Jill","Jones");
        addressTree.lookup("John","Doe");
        addressTree.lookup("Jill","Jones");
        addressTree.lookup("John","Doe");
        addressTree.lookup("Nadezhda","Kanachekhovskaya");
        addressTree.lookup("Mallard","Fillmore");
    }

}
