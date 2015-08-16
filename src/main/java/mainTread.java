import Notifications.EventsSettingsForm;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class mainTread {
    static TrayIcon trayIcon;
    static Integer timerPeriod = 60000;
    static Timer timerServersTest = new Timer(timerPeriod, new TimerActivationEvents());

    public static void main(String[] args) {
        addImageToTray();
        timerServersTest.start();
    }

    private static void addImageToTray(){
        SystemTray systemTray = SystemTray.getSystemTray();
        Image image = getImageTray(true);
        PopupMenu popup = trayAppPopupMenu();

        trayIcon = new TrayIcon(image);
        trayIcon.setImageAutoSize(true);
        trayIcon.setPopupMenu(popup);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(mainTread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PopupMenu trayAppPopupMenu(){
        PopupMenu popup = new PopupMenu();

        MenuItem authenticationItem = new MenuItem("Авторизация");
        authenticationItem.addActionListener(new AuthenticationButtonClick());
        popup.add(authenticationItem);

        MenuItem notificationItem = new MenuItem("Настройки уведомлений");
        notificationItem.addActionListener(new NotificationButtonClick());
        popup.add(notificationItem);

        MenuItem settingsItem = new MenuItem("Настройки серверов 1С");
        settingsItem.addActionListener(new ServersSettingsButtonClick());
        popup.add(settingsItem);

        MenuItem exitItem = new MenuItem("Выход");
        exitItem.addActionListener(new ExitButtonClick());
        popup.add(exitItem);

        return popup;
    }

    private static Image getImageTray(Boolean isGood){
        String imageName = (isGood)?("Circle_Green.png"):("Circle_Red.png");
        URL imageUrl = mainTread.class.getResource("Images/" + imageName);
        Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);

        return image;
    }

    static class ExitButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    static class ServersSettingsButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            ServersSettingsForm serververSettingsForm = new ServersSettingsForm();
//            serververSettingsForm.show();
        }
    }

    static class NotificationButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EventsSettingsForm eventsSettingsForm = new EventsSettingsForm();
            eventsSettingsForm.setResizable(false);
            Dimension panelSize = new Dimension(400,215);
            eventsSettingsForm.setSize(panelSize);
            eventsSettingsForm.setVisible(true);
        }
    }

    static class AuthenticationButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            ServerAuthenticationForm serverAuthenticationSettingsForm = new ServerAuthenticationForm();
//            serverAuthenticationSettingsForm.show();
        }
    }

    static class TimerActivationEvents implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            timerServersTest.stop();
            Image image = getImageTray(false);
            trayIcon.setImage(image);
            timerServersTest.start();
        }
    }
}