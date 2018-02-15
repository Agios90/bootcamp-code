package simpleperson;

public class Person {
    
    private String name;
    private String lname;
    private String fname;
    private String date;
    private int age;
    
    public String getString(int i) {
	if (i==1) return name;
        if (i==2) return lname;
        if (i==3) return fname;
        if (i==4) return date;
        return null;
    }
   
    public int getAge() {
        return age;
    }

    public void setString(int i, String s) {
        if (i==1) this.name = s;
        if (i==2) this.lname = s;
        if (i==3) this.fname = s;
        if (i==4) this.date = s;
    }
  
    public void setAge(int age) {
        this.age = age;
    }
    
}
    

