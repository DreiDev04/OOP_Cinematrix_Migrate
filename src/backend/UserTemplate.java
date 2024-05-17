package backend;

import java.time.LocalDate;
import java.lang.reflect.Method;

interface INT_UserTemplate {

    // Method signatures
    String getUID();

    void setUID(String UID);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getAge();

    void setAge(int age);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    String getFieldValue(String fieldName);


}

public class UserTemplate implements INT_UserTemplate {

    private String UID;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String password;
    private LocalDate birthDate;


    // Parameterized constructor
    public UserTemplate(String UID, String firstName, String lastName, int age, String username, String password, LocalDate birthDate) {
        this.UID = UID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
    }
    public UserTemplate(){
    
    }

    // Getters and setters
    @Override
    public String getFieldValue(String fieldName) {
        try {
            // Construct the getter method name based on the fieldName
            String getterMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            // Use reflection to invoke the getter method and retrieve the value
            Method getterMethod = getClass().getMethod(getterMethodName);
            return String.valueOf(getterMethod.invoke(this));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getUID() {
        return UID;
    }

    @Override
    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
