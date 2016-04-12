 
/**
 * C189 - Data Structures Performance Assessment
 * Address Book Hash and Tree Demo
 * Entry Class Definition
 * 
 * @author Alissa Rogers, WGU, Student ID 000387345
 */
public class Entry {
    // AR -instance variables
    private String fName;
    private String lName;
    private String email;
    private String phone;
    
    /**
     * Constructor for objects of type Entry
     * 
     * @param fName First name
     * @param lName Last Name
     * @param phone Phone number
     * @param email Email address
     */
    public Entry(String fName, String lName, String phone, String email) {
        setfName(fName);
        setlName(lName);
        setEmail(email);
        setPhone(phone);        
    }
    
    /**
     * Sets first name
     * 
     * @param fName First name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }
    
    /**
     * Sets last name
     * 
     * @param lName Last name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }
    
    /**
     * Sets email address
     * 
     * @param email Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Sets phone number
     * 
     * @param phone Phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Gets first name
     * 
     * @return First name
     */
    public String getfName() {
        return fName;
    }
    
    /**
     * Gets last name
     * 
     * @return Last name
     */
    public String getlName() {
        return lName;
    }
    
    /**
     * Gets email address
     * 
     * @return Email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Gets phone number
     * 
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }
    
    public void displayEntry() {
        System.out.println("  Name:  " + this.fName + " " + this.lName);
        System.out.println("  Email: " + this.email);
        System.out.println("  Phone: " + this.phone);
    }
}
