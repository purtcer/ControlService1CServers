package ServerAuthentication;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ServerAuthenticationForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField user;
    private JTextField password;

    public ServerAuthenticationForm() {
        setContentPane(contentPane);
        setModal(false);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        try {
            fillSettingsOnForm();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    private void onOK() {
        saveSettingsFromForm();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    //public static void main(String[] args) {
    //    ServerAuthenticationForm dialog = new ServerAuthenticationForm();
    //    dialog.pack();
    //    dialog.setVisible(true);
    //    System.exit(0);
    //}

    private void fillSettingsOnForm() {
        ServerAuthenticationStorage settingsStorage = new ServerAuthenticationStorage();
        String[] serverAuthentication = settingsStorage.getServerAuthentication();
        user.setText(serverAuthentication[0]);
        password.setText(serverAuthentication[1]);
    }

    private void saveSettingsFromForm() {
        String userName = user.getText();
        String passwordString = password.getText();
        String[] eventsSettings = {userName, passwordString};
        ServerAuthenticationStorage settingsStorage = new ServerAuthenticationStorage();
        settingsStorage.setServerAuthentication(eventsSettings);
    }

    public void pressSaveButton(){
        onOK();
    }

    public boolean settingsisCorrect(List<String> settingsList)throws Throwable{

        boolean settingsCorrect = true;
        String exteptiontext = "";
        if(!user.getText().equals(settingsList.get(0))){
            exteptiontext = "Пользователь некоректен";
            settingsCorrect = false;
        }
        if(!password.getText().equals(settingsList.get(1))){
            exteptiontext = "Пароль некоректен";
            settingsCorrect = false;
        }
        if(!settingsCorrect){
            Exception exteptionSettings = new RuntimeException(exteptiontext);
            throw exteptionSettings;
        }

        return settingsCorrect;
    }

}
