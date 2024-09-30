package Person;

import java.time.LocalDate;

public class Student extends Person {
    private String id;
    private String program;
    private LocalDate dOB;
    private Gender gender;
    public Student() {}
    public Student(String id,String name,String address, String program, LocalDate dOB, Gender gender) {
        super(name,address);
        this.id = id;
        this.program = program;
        this.dOB = dOB;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


    public LocalDate getdOB() {
        return dOB;
    }

    public void setdOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public String getName(){
        return super.getName();
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    public int getAge(){
        return Math.abs(LocalDate.now().getYear() - this.getdOB().getYear());
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", program='" + program + '\'' +
                ", dOB=" + dOB +
                ", age=" + this.getAge() +
                ", gender=" + gender +
                '}';
    }
}
