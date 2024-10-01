package E7;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Staff> staffs = new ArrayList<Staff>();
        staffs.add(new Manager("Nguyen Ngoc Duc", 2000, 700));
        staffs.add(new Manager("Nguyen Hong Ngoc", 2500, 500));
        staffs.add(new Manager("Le Thi Thu", 1000, 150));

        staffs.add(new Technician("Le Thi Thuy", 500, 50));
        staffs.add(new Technician("Bui Thi Thuy", 550, 70));
        staffs.add(new Technician("Nguyen Huy Duc", 600, 85));

        System.out.print("Nhập Tên Nhân Viên Muốn Tìm Kiếm Trả Tiền: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputName = reader.readLine();
            List<Staff> filteredStaff = staffs.stream()
                    .filter(staff -> staff.getName().toLowerCase().contains(inputName.toLowerCase()))
                    .toList();
            if (filteredStaff.isEmpty()) {
                System.out.println("Không Tìm Thấy Thông Tin Của Staff!");
            } else {
                filteredStaff.forEach(staff -> {
                    System.out.println("Staff : "+staff.getName()+" đã được thanh toán : "+staff.getPaid() + "$");
                });
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc input!");
        }

        Optional<Staff> anyManager = staffs.stream()
                .filter(staff -> staff instanceof Manager)           //.skip(2)
                .findFirst();
        System.out.println(anyManager);
        Optional<Staff> anyTechnician = staffs.stream()
                .filter(staff -> staff instanceof Technician)           //.skip(1)
                .findFirst();
        System.out.println(anyTechnician);
    }
}
