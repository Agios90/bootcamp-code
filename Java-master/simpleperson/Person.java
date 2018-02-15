package simpleperson;

public class Person {
    
    private String name;
    private String lname;
    private String fname;
    private String date;
    private int age;
    
    public String getName() {
	return name;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public String getDate() {
        return date;
    }
    
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}
    

