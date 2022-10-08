package team.ghjly.emergencyrescue.util;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要加密的密码：");
        String password = scanner.next();
        String newPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("加密后的密码：" + newPassword);
    }
}
