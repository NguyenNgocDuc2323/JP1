package StaffController;

import Person.Gender;
import Person.Staff;
import Person.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StaffController extends Staff {
    private List<Staff> staffs;
    public StaffController(List<Staff> staffs) {
        this.staffs = staffs;
    }
    public Optional<Staff> getMaxPayStaff(Gender gender) {
        Optional<Staff> maxPayStaff = staffs.stream()
                .max(Comparator.comparing(Staff::getPay))
                .filter(staff -> staff.getGender() == Gender.F);
        return maxPayStaff;
    }
    public List<Staff> getStaffById(String id) {
        List<Staff> fillByIdStaff = staffs.stream()
                .filter(staff -> staff.getId().toLowerCase().contains(id.toLowerCase()))
                .toList();
        return fillByIdStaff;
    }
    public List<Staff> getStaffByName(String name) {
        List<Staff> fillByNameStaff = staffs.stream()
                .filter(staff -> staff.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        return fillByNameStaff;
    }

}
