package ServerAuthentication;

import java.util.prefs.Preferences;

public class ServerAuthenticationStorage {
    String PreferenceEvents = "ServerAuthentication";
    Preferences PreferencesEvents = Preferences.userRoot().node(PreferenceEvents);

    public void setServerAuthentication(String[]EventsSettings){
        PreferencesEvents.put("User", (String)EventsSettings[0]);
        PreferencesEvents.put("Password", (String)EventsSettings[1]);
    }

    public String[] getServerAuthentication(){
        String user = PreferencesEvents.get("User", "");
        String password = PreferencesEvents.get("Password", "");
        String[] eventsSettings = {user, password};

        return eventsSettings;
    }
}
