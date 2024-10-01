package Banking.Service;

import Banking.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    private Account account;
    private double amount;
    public ValidateData(Account account) {
        this.account = account;
    }
    public double validateAmount(Account account, String input) {

        Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            double amount = Double.parseDouble(input);
            if (account.getBalance() >= amount) {
                return amount;
            } else {
                System.out.println("Số Dư Không Đủ!");
                return 0;
            }
        } else {
            System.out.println("Số Tiền Phải Là 1 Số!");
            return  0;
        }
    }


}
