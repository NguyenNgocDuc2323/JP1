package E7;

public class Technician extends Staff{
    private double overtimePay;
    public Technician(){;}
    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }
    @Override
    public double getPaid() {
        return super.getSalary() + this.overtimePay;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "overtimePay=" + overtimePay +
                " name="+super.getName()+
                " salary="+super.getSalary()+
                " paid=" + getPaid() +
                '}';
    }
}
