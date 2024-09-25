package E2;

public class Test_Main {
    public static void main(String[] args) {

        Employee e1 = new Employee(1,"Ngọc","Hồng Nguyễn",2500);
        e1.raiseSalary(5);
        System.out.println(e1);
        System.out.println("\n+---------------------------------+");


        Employee employees[] = {
                new Employee(1,"Đức","Nguyễn Ngọc",2500),
                new Employee(2,"Hùng","Nguyễn Văn",1000),
                new Employee(3,"Đại","Lê Quang",5000),
        };


        Employee maxAnualSalary = employees[0];
        for(int i=0;i<employees.length;i++){
            System.out.print(employees[i]);
            System.out.print(", Anual Salary : "+employees[i].anualSalary());
            if(employees[i].anualSalary() > maxAnualSalary.anualSalary()){
                maxAnualSalary = employees[i];
            }
        }
        System.out.println("\n+---------------------------------+");
        System.out.println("Max Salary : "+maxAnualSalary.anualSalary());

    }
}
