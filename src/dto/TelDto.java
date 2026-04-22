package dto;

public class TelDto {
<<<<<<< HEAD
    private Long id;
=======
    private Long id;  // 4L
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
    private String name;
    private int age;
    private String address;
    private String telNumber;

    public TelDto(Long id, String name, int age, String address, String telNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "TelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
