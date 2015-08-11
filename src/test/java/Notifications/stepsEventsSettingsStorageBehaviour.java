package Notifications;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class stepsEventsSettingsStorageBehaviour {
    EventsSettingsStorage settingsStorage;

    @Given("^application is not run$")
    public void application_is_not_run()throws Throwable{
        if(settingsStorage != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When ("^I run application$")
    public void I_run_application()throws Throwable{
        settingsStorage = new EventsSettingsStorage();
    }

    @Then ("app save settings: (.*)")
    public void app_save_settings(List<String> mail)throws Throwable{
        String[] settings = {mail.get(0), mail.get(1), mail.get(2), mail.get(3), mail.get(4)};
        settingsStorage.setEventsSettings(settings);
    }

    @Then ("app restor settings: (.*)")
    public void app_restor_settings(List<String> mail)throws Throwable{
        String[] settingsTest = {mail.get(0), mail.get(1), mail.get(2), mail.get(3), mail.get(4)};
        String[] settingsSave = settingsStorage.getEventsSettings();
        int testLeigth = settingsTest.length;
        int saveLeigth = settingsSave.length;
        if(testLeigth == saveLeigth) {
            for(int i = 0; i < testLeigth; i++) {
                if(!settingsTest[i].equals(settingsSave[i])){
                    Exception exteptionText = new RuntimeException("Восстановленные настройки отличаются от заданных.");
                    throw exteptionText;
                }
            }
        }
        else{
            Exception exteptionText = new RuntimeException("Восстановленные настройки отличаются от заданных.");
            throw exteptionText;
        }
    }
}