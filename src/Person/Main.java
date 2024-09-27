package Person;

import StaffController.StaffController;
import StudentController.StudentController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        List<Staff> staffs = new ArrayList<Staff>();
        StudentController sc = new StudentController(students);
        StaffController st = new StaffController(staffs);
        Scanner scanner = new Scanner(System.in);
        students.add(new Student("STUDENT1", "Nguyen Ngoc Duc", "Thanh Hoa", "ADSE", LocalDate.of(2001, 03, 23), Gender.M));
        students.add(new Student("STUDENT2", "Nguyen Ngoc Ha", "Ha Noi", "ADSE", LocalDate.of(2003, 05, 23), Gender.F));
        students.add(new Student("STUDENT3", "Nguyen Thi Tu", "Quang Ninh", "ADSE", LocalDate.of(2006, 10, 13), Gender.F));
        staffs.add(new Staff("ST1", "Nguyen Thi Phuong", "Thanh Hoa", Gender.F, 3250, LocalDate.of(1975, 05, 23)));
        staffs.add(new Staff("ST2", "Le Van Cuong", "Quang Ninh", Gender.M, 1500, LocalDate.of(1943, 10, 3)));
        staffs.add(new Staff("ST3", "Ha Thi Nhu Quynh", "Ho Chi Minh", Gender.F, 2000, LocalDate.of(2000, 10, 25)));
        Optional<Student> stdYoungest = sc.getYoungest();
//        System.out.println(stdYoungest);
//        System.out.print("Input Name For Search : ");
//        String name = scanner.nextLine();
//        StudentController.searchStudentByName(name).forEach(System.out::println);
//        B1:
        Optional<Staff> maxPayStaff = st.getMaxPayStaff(Gender.F);
        System.out.println(maxPayStaff);

        B2:
        System.out.print("Nhập vào Id : ");
        String fillId = scanner.nextLine();
        List<Staff> fillIdStaff = st.getStaffById(fillId);
        fillIdStaff.forEach(System.out::println);
//        scanner.nextLine();
        System.out.print("Nhập vào Tên Staff: ");
        String fillName = scanner.nextLine();
        List<Staff> fillNameStaff = st.getStaffByName(fillName);
        fillNameStaff.forEach(System.out::println);

        //B3:
        System.out.print("\nNhập Mã Nhân Viên Cuả Bạn : ");
        String staffId = scanner.nextLine();
        Optional<Staff> changeStaff = staffs.stream()
                .filter(s -> s.getId().toLowerCase().equals(staffId.toLowerCase()))
                .findFirst();
        if(changeStaff.isPresent()) {
            System.out.print("\nMời Nhập Tên Muốn Đổi : ");
            String changeName = scanner.nextLine();
            changeStaff.get().setName(changeName);
            System.out.println("Tên đã được thay đổi thành công!");
            System.out.println(changeStaff);
        }
        else{
            System.out.print("\nKhông Tìm Thấy Id Của Staff Muốn Đổi! ");
        }

    }
}
