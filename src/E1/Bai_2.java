package E1;

import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit_money;
        while (true) {
            System.out.print("Nhập Số Tiền Muốn Gửi (VND): ");
            deposit_money = scanner.nextDouble();
            if (deposit_money < 1000000) {
                System.out.println("Số Tiền Bạn Gửi Quá Nhỏ! (>= 1 Triệu VND)");
            } else {
                break;
            }
        }

        int kiHan[] = {6,9,12,24,36};
        double laiSuat[] = {5.1,5.5,6.4,6.5,6.5};
        System.out.println("+---------------------------------+");
        System.out.println("|     Số Tháng   |    Lãi Suất    |");
        System.out.println("+---------------------------------+");
        for (int i = 0; i < kiHan.length; i++) {
            System.out.printf("|       %d        |      %.1f      |\n", kiHan[i], laiSuat[i]);
        }
        System.out.println("+---------------------------------+");
        System.out.print("Số Tháng Bạn Muốn Gửi: ");
        int choise = scanner.nextInt();
        if((choise % 3 != 0)){
            System.out.println("Số Tháng Không Hợp Lệ! (Các Thời Hạn Cho Vay : 6, 9, 12, 24, 36 Tháng)");
            return;
        }
        double lai_suat = 0;

        switch (choise) {
            case 6:
                lai_suat = 0.51;
                break;
            case 9:
                lai_suat = 0.55;
                break;
            case 12:
                lai_suat = 0.64;
                break;
            case 24:
                lai_suat = 0.65;
                break;
            case 36:
                lai_suat = 0.65;
                break;
            default:
                lai_suat = 0.51;
                break;
        }
        double total = deposit_money + (deposit_money * lai_suat);
        System.out.printf("Tổng Số Tiền Sau Khi Gửi %d Tháng Là: %.0f VND\n",choise, total);
    }
}
