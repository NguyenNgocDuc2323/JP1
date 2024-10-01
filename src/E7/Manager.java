package E7;

public class Manager extends Staff{
    private double allowance;

    public Manager(String name, double salary, double allowance) {
        super(name, salary);
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public double getPaid() {
        return super.getSalary() + this.allowance;
    }

    @Override
    public String toString() {
        return "Manager{" +
                " allowance=" + allowance +
                " name=" + super.getName() +
                ", salary=" + super.getSalary() +
                " paid=" + getPaid() +
                '}';
    }
}
