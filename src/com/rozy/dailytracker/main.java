package com.rozy.dailytracker;

import com.rozy.dailytracker.dekstop.loginFrame;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class main {

//    login data handler
    static HashMap<String, String> userLog = new HashMap<>();

    final static String userAdmin = "admin";
    final static String passAdmin = "PremiumTicket";
    public static String userLogged = "";

    private static boolean succesLog = false;

//    userdata
//    login var
    public void addUser(String user, String pass) {
        if (userLog.containsKey(user)) {
            JOptionPane.showMessageDialog(null, "Username Sudah Diambil",
                    "Daily Tracker", HEIGHT);
        } else {
            userLog.put(user, pass);
            JOptionPane.showMessageDialog(null, "Anda telah Membuat Akun",
                    "Daily Tracker", HEIGHT);
        }
        if (user.equals("show") && pass.equals("SHOWMEPLS")) {
            System.out.println("User List: " + userLog);
        }
    }

    public void logUser(String user, String pass) {
        String pw = userLog.get(user);
        if (userLog.containsKey(user) && pass.equals(pw)) {
            JOptionPane.showMessageDialog(null, "Anda Telah Login",
                    "Daily Tracker", HEIGHT);
            userLogged = user;
            succesLog = true;
            if (user.equals(userAdmin) && pw.equals(passAdmin)) {
                boolean isAdmin = true;
                System.out.println("You're " + isAdmin + " Admin now!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password Anda Salah",
                    "Daily Tracker", HEIGHT);
        }
    }

    public boolean getsuccesLog() {
        return succesLog;
    }

    public void setsuccesLog(boolean succesLog) {
        main.succesLog = succesLog;
    }

//    run frame
    public static void main(String[] args) {
        userLog.put(userAdmin, passAdmin);
        userLog.put("show", "");
        loginFrame loginFrame = new loginFrame();
        loginFrame.mainFrame();
    }
}
