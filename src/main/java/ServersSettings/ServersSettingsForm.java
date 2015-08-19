package ServersSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ServersSettingsForm extends JDialog {
    private JComboBox serverVersion;
    private JTextField serverAddress;
    private JTextField serverPort;
    private JButton serverTestConnect;
    private JButton serverAdd;
    private JLabel serverVersionLabel;
    private JLabel serverAddressLabel;
    private JLabel serverPortLabel;
    private JTable serversList;
    private JPanel contentPane;
    private JButton Delete;
    private JButton Save;
    private JButton Exit;
    private ServersTableModel serversTableModel;

    private void createUIComponents() {

    }

    public ServersSettingsForm(){
        setContentPane(contentPane);
        setModal(false);
        ServersSettingsStorage serversSettings = new ServersSettingsStorage();
        Vector serversTableData = serversSettings.getCentralServers();
        serversTableModel = new ServersTableModel(serversTableData);
        serversList.setModel(serversTableModel);

        serverTestConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                serverAddActionPerformed(e);
            }
        });

        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveActionPerformed(e);
            }
        });

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteActionPerformed(e);
            }
        });

        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExitActionPerformed(e);
            }
        });

    }

    private void serverAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (isAllFilesFilled()){
            String serverVersionValue = (String)(serverVersion.getSelectedItem());
            String serverAddressValue = serverAddress.getText();
            String serverPortValue = serverPort.getText();
            Object[] rowServer = {serverVersionValue, serverAddressValue, serverPortValue};
            serversTableModel.addRowTable(rowServer);
            serversList.setModel(serversTableModel);
            serversList.updateUI();
        }
    }

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {
        Vector serversTableData = serversTableModel.getTableData();
        ServersSettingsStorage serversSettings = new ServersSettingsStorage();
        serversSettings.setCentralServers(serversTableData);
    }

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = serversList.getSelectedRow();
        serversTableModel.deleteRowTable(selectedRow);
        serversList.setModel(serversTableModel);
        serversList.updateUI();
    }

    private boolean isAllFilesFilled() {

        boolean allFilesFilled = true;
        String serverAddressValue = serverAddress.getText();
        if(serverAddressValue.isEmpty()){
            allFilesFilled = false;
            JOptionPane.showMessageDialog(null, "Не заполнен адрес компьютера сервера 1С:Предприятия.");
        }
        String serverPortValue = serverPort.getText();
        if(serverPortValue.isEmpty()){
            allFilesFilled = false;
            JOptionPane.showMessageDialog(null, "Не заполнен порт компьютера сервера 1С:Предприятия.");
        }

        return allFilesFilled;
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

}
