package E1;

import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] deposit_able = { 500000, 200000, 100000, 50000 };
        System.out.print("Nhập Số Tiền Bạn Muốn Rút: ");
        double deposit_money = scanner.nextDouble();
        if (deposit_money < 50000) {
            System.out.println("Số Dư Trong Tài Khoản Không Đủ!");
            return;
        } else if (deposit_money >= 50000 && (deposit_money % 50000 != 0)) {
            System.out.println("Số Dư Phải Chia Hết Cho 50000 VND!");
            return;
        } else {
            System.out.println("+---------------------------------+");
            System.out.println("|  Số Tiền  |  Mệnh Giá  |  Số Tờ |");
            System.out.println("+---------------------------------+");
            for (int i = 0; i < deposit_able.length; i++) {
                if (deposit_money >= deposit_able[i]) {
                    int count = (int) (deposit_money / deposit_able[i]);
                    System.out.printf("|  %.0f  |  %.0f VND  |  %d Tờ   |\n", deposit_money, deposit_able[i], count);
                    deposit_money %= deposit_able[i];
                }
            }
            System.out.println("+---------------------------------+");
        }
    }
}
