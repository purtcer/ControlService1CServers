package Notifications;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;

public class stepsEventsSettingsStorageBehaviour {
    EventsSettingsStorage settingsStorage;

    @Given("^application not is not run$")
    public void application_not_is_not_run()throws Throwable{
        if(settingsStorage != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When ("^I run not application$")
    public void I_run_not_application()throws Throwable{
        settingsStorage = new EventsSettingsStorage();
    }

    @Then ("app save settings: (.*)")
    public void app_save_settings(List<String> settings)throws Throwable{
        String[] settingsList = {settings.get(0), settings.get(1), settings.get(2), settings.get(3), settings.get(4)};
        settingsStorage.setEventsSettings(settingsList);
    }

    @Then ("app restor settings: (.*)")
    public void app_restor_settings(List<String> settings)throws Throwable{
        String[] settingsTest = {settings.get(0), settings.get(1), settings.get(2), settings.get(3), settings.get(4)};
        String[] settingsSave = settingsStorage.getEventsSettings();
        if(!Arrays.equals(settingsTest, settingsSave)) {
            Exception exteptionText = new RuntimeException("Восстановленные настройки отличаются от заданных.");
            throw exteptionText;
        }
    }
}