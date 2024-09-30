package Entiy;

public class Customer {
    private int ID;
    private String name;
    Gender gender;
    private int discount;
    public Customer() {}
    public Customer(int ID, String name, Gender gender, int discount) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.discount = discount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", discount=" + discount +
                '}';
    }
}
