package ServersSettings;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ServersSettingsStorage {

    Preferences PreferencesCentralServers;
    Preferences PreferencesCentralServerNode;
    String PreferenceServer = "CentralServers";
    String serverNodeName = "Server";

    public void setCentralServers(Vector CentralServers){
        ClearCentralServers();
        PreferencesCentralServers = Preferences.userRoot().node(PreferenceServer);
        int leightCentralServers = CentralServers.size();
        for (int i = 0; i < leightCentralServers; i++) {
            String NumServer = Integer.toString(i);
            String ServerNum = serverNodeName + NumServer;
            PreferencesCentralServerNode = PreferencesCentralServers.node(ServerNum);
            AddCentralServerToPreferences(PreferencesCentralServerNode, (Object[])(CentralServers.get(i)));
        }
    }

    public Vector getCentralServers(){
        PreferencesCentralServers = Preferences.userRoot().node(PreferenceServer);
        int leightCentralServers = 0;
        String[] centralServersPreference;
        try {
            centralServersPreference = PreferencesCentralServers.childrenNames();
            leightCentralServers = centralServersPreference.length;
        } catch (BackingStoreException ex) {
            Logger.getLogger(ServersSettingsStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vector CentralServers = new Vector();
        if (leightCentralServers > 0){
            for (int i = 0; i < leightCentralServers; i++) {
                String NumServer = Integer.toString(i);
                String ServerNum = serverNodeName + NumServer;
                PreferencesCentralServerNode = PreferencesCentralServers.node(ServerNum);
                Object[] nodeServer = serverSettings(PreferencesCentralServerNode);
                CentralServers.add(nodeServer);
            }
        }

        return CentralServers;
    }

    private void ClearCentralServers(){
        PreferencesCentralServers = Preferences.userRoot().node(PreferenceServer);
        try {
            PreferencesCentralServers.clear();
        } catch (BackingStoreException ex) {
            Logger.getLogger(ServersSettingsStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AddCentralServerToPreferences(Preferences PreferencesCentralServerNode, Object[] CentralServerElement) {
        PreferencesCentralServerNode.put("ServerVersion", (String)CentralServerElement[0]);
        PreferencesCentralServerNode.put("ServerPC", (String)CentralServerElement[1]);
        PreferencesCentralServerNode.put("ServerPort", (String)CentralServerElement[2]);
    }

    private Object[] serverSettings(Preferences PreferencesCentralServerNode){
        String serverVersion = PreferencesCentralServerNode.get("ServerVersion", "");
        String serverPC = PreferencesCentralServerNode.get("ServerPC", "");
        String serverPort = PreferencesCentralServerNode.get("ServerPort", "");
        Object[] nodeServer = {serverVersion, serverPC, serverPort};

        return nodeServer;
    }

}
