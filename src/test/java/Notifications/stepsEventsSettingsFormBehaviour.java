package Notifications;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;

public class stepsEventsSettingsFormBehaviour {
    EventsSettingsForm settingsForm;

    @Given("^form settings is not run$")
    public void form_settings_is_not_run()throws Throwable{
        if(settingsForm != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When("^I run form settings$")
    public void I_run_form_settings()throws Throwable{
        settingsForm = new EventsSettingsForm();
        settingsForm.setVisible(true);
    }

    @Then("app restore settings on form: (.*)")
    public void app_restor_settings_on_form(List<String> notificationSettings)throws Throwable{
        settingsForm.settingsisCorrect(notificationSettings);
    }

    @Given("^notifications settings form is open$")
    public void notifications_settings_form_is_open()throws Throwable{
        settingsForm = new EventsSettingsForm();
        settingsForm.setVisible(true);
        if(settingsForm == null){
            Exception exteptionIcon = new RuntimeException("Приложение не запущено.");
            throw exteptionIcon;
        }
    }

    @When("^I press save button$")
    public void I_press_save_button()throws Throwable{
        settingsForm.pressSaveButton();
    }

    @Then("app save settings on form: (.*)$")
    public void app_save_settings_on_form(List<String> notificationSettings)throws Throwable{
        EventsSettingsStorage settingsStorage = new EventsSettingsStorage();
        String[] settingsTest = {notificationSettings.get(0), notificationSettings.get(1), notificationSettings.get(2), notificationSettings.get(3), notificationSettings.get(4)};
        String[] settingsSave = settingsStorage.getEventsSettings();
        if(!Arrays.equals(settingsTest, settingsSave)) {
            Exception exteptionText = new RuntimeException("Сохраненные настройки отличаются от заданных.");
            throw exteptionText;
        }
    }
}
