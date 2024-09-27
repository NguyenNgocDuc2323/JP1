package Person;

import java.time.LocalDate;

public class Staff extends Person {
    private Gender gender;
    private double pay;
    private String id;
    private LocalDate dateJoin;
    public Staff() {}
    public Staff(String id, String name, String address, Gender gender, double pay, LocalDate dateJoin) {
        super(name,address);
        this.pay = pay;
        this.id = id;
        this.gender = gender;
        this.dateJoin = dateJoin;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getdOB() {
        return dateJoin;
    }

    public void setdOB(LocalDate dOB) {
        this.dateJoin = dOB;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + this.id +
                " name=" + this.getName()+
                ", address=" + this.getAddress() +
                " gender=" + gender +
                ", pay=" + pay +
                ", dOB=" + dateJoin +
                '}';
    }
}
