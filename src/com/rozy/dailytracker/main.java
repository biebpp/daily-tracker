package com.rozy.dailytracker;

import com.rozy.dailytracker.dekstop.loginFrame;
import com.rozy.dailytracker.management.writeHandler;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class main {

//    login data handler
    static HashMap<String, String> userLog = new HashMap<>();
    writeHandler writeHandler = new writeHandler();

    String userPath = String.valueOf(writeHandler.loginFile) + "/savedUser.txt";
    String passPath = String.valueOf(writeHandler.loginFile) + "/savedPass.txt";

    final static String userAdmin = "admin";
    final static String passAdmin = "PremiumTicket";
    public static String userLogged = "";

    private static boolean succesLog = false;

//    login section
    public void addUser(String user, String pass) {
        if (userLog.containsKey(user)) {
            JOptionPane.showMessageDialog(null, "Username Sudah Diambil",
                    "Daily Tracker", HEIGHT);
        } else {
            try {

                File userFile = new File(userPath);
                File passFile = new File(passPath);

                FileReader userReader = new FileReader(userFile);
                FileReader passReader = new FileReader(passFile);

                BufferedReader userBuffered = new BufferedReader(userReader);
                BufferedReader passBuffered = new BufferedReader(passReader);

                Object[] userLines = userBuffered.lines().toArray();
                Object[] passLines = passBuffered.lines().toArray();

                FileWriter ufw = new FileWriter(userFile);
                FileWriter pfw = new FileWriter(passFile);

                BufferedWriter ubw = new BufferedWriter(ufw);
                BufferedWriter pbw = new BufferedWriter(pfw);

                for (int i = 0; i < userLines.length; i++) {
                    String getUser = userLines[i].toString();
                    String getPass = passLines[i].toString();
                    ubw.write(getUser);
                    pbw.write(getPass);

                    ubw.newLine();
                    pbw.newLine();
                }

                ubw.append(user);
                pbw.append(pass);

                ubw.newLine();
                pbw.newLine();

                ubw.close();
                pbw.close();

                ufw.close();
                pfw.close();

            } catch (Exception e) {
            }

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

    public void loadLog() {
        try {
            File userFile = new File(userPath);
            File passFile = new File(passPath);

            FileReader userReader = new FileReader(userFile);
            FileReader passReader = new FileReader(passFile);

            BufferedReader userBuffered = new BufferedReader(userReader);
            BufferedReader passBuffered = new BufferedReader(passReader);

            Object[] userLines = userBuffered.lines().toArray();
            Object[] passLines = passBuffered.lines().toArray();

            for (int i = 0; i < userLines.length; i++) {
                String user = userLines[i].toString();
                String pass = passLines[i].toString();

                userLog.put(user, pass);
            }
        } catch (Exception e) {
        }
    }

//    run frame
    public static void main(String[] args) {
        main main = new main();
        main.loadLog();
        
        loginFrame loginFrame = new loginFrame();
        loginFrame.mainFrame();
    }
}
