package Notifications;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EventsSettingsForm extends JDialog {
    private JPanel contentPane;
    private JButton Save;
    private JButton Exit;
    private JTextField calendarEMail;
    private JTextField calendarClientId;
    private JLabel calendarClientIdLabel;
    private JLabel calendarEMailLabel;
    private JLabel calendarClientSecretLabel;
    private JTextField calendarClientSecret;
    private JLabel calendarNameLabel;
    private JTextField calendarName;
    private JLabel calendarTimeCorrectionLabel;
    private JTextField calendarTimeCorrection;

    public EventsSettingsForm() {
        setContentPane(contentPane);
        setModal(false);
        getRootPane().setDefaultButton(Save);

        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        Exit.addActionListener(new ActionListener() {
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
        try {
            saveSettingsFromForm();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void fillSettingsOnForm() {
        EventsSettingsStorage settingsStorage = new EventsSettingsStorage();
        String[] eventsSettings = settingsStorage.getEventsSettings();
        calendarEMail.setText((String)eventsSettings[0]);
        calendarClientId.setText((String)eventsSettings[1]);
        calendarClientSecret.setText((String)eventsSettings[2]);
        calendarName.setText((String)eventsSettings[3]);
        calendarTimeCorrection.setText((String) eventsSettings[4]);
    }

    public void saveSettingsFromForm(){
        String eMail = calendarEMail.getText();
        String clientId = calendarClientId.getText();
        String clientSecret = calendarClientSecret.getText();
        String name = calendarName.getText();
        String timeCorrection = calendarTimeCorrection.getText();
        String[] eventsSettings = {eMail, clientId, clientSecret, name, timeCorrection};
        EventsSettingsStorage settingsStorage = new EventsSettingsStorage();
        settingsStorage.setEventsSettings(eventsSettings);
    }

    public void pressSaveButton(){
        onOK();
    }

    public boolean settingsisCorrect(List<String> settingsList)throws Throwable{

        boolean settingsCorrect = true;
        String exteptiontext = "";
        if(!calendarEMail.getText().equals(settingsList.get(0))){
            exteptiontext = "Адрес электронной почты некоректен";
            settingsCorrect = false;
        }
        if(!calendarClientId.getText().equals(settingsList.get(1))){
            exteptiontext = "Идентификатор клиента некоректен";
            settingsCorrect = false;
        }
        if(!calendarClientSecret.getText().equals(settingsList.get(2))){
            exteptiontext = "Client Secret некоректен";
        }
        if(!calendarName.getText().equals(settingsList.get(3))){
            exteptiontext = "Имя календаря некоректно";
            settingsCorrect = false;
        }
        if(!calendarTimeCorrection.getText().equals(settingsList.get(4))){
            exteptiontext = "Время до уведомления некорректно";
            settingsCorrect = false;
        }
        if(!settingsCorrect){
            Exception exteptionSettings = new RuntimeException(exteptiontext);
            throw exteptionSettings;
        }

        return settingsCorrect;
    }
}
