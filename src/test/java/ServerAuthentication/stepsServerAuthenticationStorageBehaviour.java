package ServerAuthentication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class stepsServerAuthenticationStorageBehaviour {

    ServerAuthenticationStorage settingsStorage;

    @Given("^storage auth application is not run$")
    public void application_is_not_run()throws Throwable{
        if(settingsStorage != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When ("^I run application storage auth")
    public void I_run_application_storage_auth()throws Throwable{
        settingsStorage = new ServerAuthenticationStorage();
    }

    @Then ("app save settings auth: (.*)")
    public void app_save_settings_auth$(List<String> settingsList)throws Throwable{
        String[] settings = {settingsList.get(0), settingsList.get(1)};
        settingsStorage.setServerAuthentication(settings);
    }

    @Then ("app restor settings auth: (.*)")
    public void app_restor_settings_auth(List<String> settings)throws Throwable{
        String[] settingsTest = {settings.get(0), settings.get(1)};
        String[] settingsSave = settingsStorage.getServerAuthentication();
        if(!Arrays.equals(settingsTest, settingsSave)) {
            Exception exteptionText = new RuntimeException("Восстановленные настройки отличаются от заданных.");
            throw exteptionText;
        }
    }

}