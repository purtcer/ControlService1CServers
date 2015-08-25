package ServerAuthentication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;

public class stepsServerAuthenticationFormBehaviour {

    ServerAuthenticationForm settingsForm;

    @Given("^form auth settings is not run$")
    public void form_auth_settings_is_not_run()throws Throwable{
        if(settingsForm != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When("^I run auth form settings$")
    public void I_run_auth_form_settings()throws Throwable{

        settingsForm = new ServerAuthenticationForm();
        settingsForm.setVisible(true);
    }

    @Then("app auth restore settings on form: (.*)")
    public void app_restor_settings_on_form(List<String> notificationSettings)throws Throwable{
        settingsForm.settingsisCorrect(notificationSettings);
        settingsForm.dispose();
    }

    @Given("auth settings form is open")
    public void notifications_settings_form_is_open()throws Throwable{
        settingsForm = new ServerAuthenticationForm();
        settingsForm.setVisible(true);
        if(settingsForm == null){
            Exception exteptionIcon = new RuntimeException("Приложение не запущено.");
            throw exteptionIcon;
        }
    }

    @When("I press auth save button")
    public void I_press_save_button()throws Throwable{
        settingsForm.pressSaveButton();
    }

    @Then("app auth save settings on form: (.*)")
    public void app_save_settings_on_form(List<String> notificationSettings)throws Throwable{
        ServerAuthenticationStorage settingsStorage = new ServerAuthenticationStorage();
        String[] settingsTest = {notificationSettings.get(0), notificationSettings.get(1)};
        String[] settingsSave = settingsStorage.getServerAuthentication();
        if(!Arrays.equals(settingsTest, settingsSave)) {
            Exception exteptionText = new RuntimeException("Сохраненные настройки отличаются от заданных.");
            throw exteptionText;
        }
        settingsForm.dispose();
    }

}
