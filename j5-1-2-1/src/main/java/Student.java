public class Student {
    private int number;
    private String name;
    private String address;
    private int age;
    Student(int number,String name, String address,int age){
        this.number = number;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}