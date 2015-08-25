package ServersSettings;

//import ServerAuthentication.ServerAuthenticationStorage;
//import com.google.api.client.util.Lists;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.*;

public class stepsServersSettingsStorageBehaviour {

    ServersSettingsStorage settingsStorage;
    Vector centralServers = getTestServersData();

    private Vector getTestServersData(){
        Vector data = new Vector();
        String[] server1 = {"1", "1", "1"};
        data.add(server1);

        String[] server2 = {"2", "2", "2"};
        data.add(server2);

        String[] server3 = {"3", "3", "3"};
        data.add(server3);

        return data;
    }

    @Given("^application sett is not run$")
    public void application_sett_is_not_run()throws Throwable{
        if(settingsStorage != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When("^I run application storage$")
    public void I_run_application_storage()throws Throwable{
        settingsStorage = new ServersSettingsStorage();
    }

    @Then("app save settings")
    public void app_save_settings()throws Throwable{
        settingsStorage.setCentralServers(centralServers);
    }

    @Then ("app restor settings")
    public void app_restor_settings()throws Throwable{
        Vector data = settingsStorage.getCentralServers();
        boolean isError = false;
        if(data.size() != centralServers.size()){
            isError = true;
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                if (!centralServers.containsAll(data)) {
                    Object[] dataArray = (Object[])data.get(i);
                    Object[] centrServersArray = (Object[])centralServers.get(i);
                    if(!Arrays.equals(dataArray, centrServersArray)){
                        isError = true;
                        break;
                    }
                }
            }
        }
        if(isError){
            Exception exteptionText = new RuntimeException("Восстановленные настройки отличаются от заданных.");
            throw exteptionText;
        }
    }

}
