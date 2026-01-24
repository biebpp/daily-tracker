package dekstop;

import static java.awt.image.ImageObserver.HEIGHT;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class main {

    HashMap<String, String> userData = new HashMap<>();

    public void addUser(String user, String pass) {
        if (userData.containsKey(user)) {
            JOptionPane.showMessageDialog(null, "Username Sudah Diambil",
                    "Daily Tracker", HEIGHT);
        } else {
            userData.put(user, pass);
            JOptionPane.showMessageDialog(null, "Anda telah Membuat Akun",
                    "Daily Tracker", HEIGHT);
        }
        System.out.println(userData);
    }

    public void logUser(String user, String pass) {
        String pw = userData.get(user);
        if (userData.containsKey(user) && pass.equals(pw)) {
            JOptionPane.showMessageDialog(null, "Anda Telah Login",
                    "Daily Tracker", HEIGHT);
        } else {
            JOptionPane.showMessageDialog(null, "Password Anda Salah",
                    "Daily Tracker", HEIGHT);
        }
        System.out.println(userData);
    }

    public static void main(String[] args) {
        loginFrame loginFrame = new loginFrame();
        loginFrame.mainFrame();
    }
}
