import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.net.URL;

public class stepsmainTreadBehaviour {

    mainTread app1CControlService;

    @Given("^application is not run$")
    public void application_is_not_run()throws Throwable{
        if(app1CControlService != null){
            Exception exteptionIcon = new RuntimeException("Приложение уже запущено.");
            throw exteptionIcon;
        }
    }

    @When ("^I run application$")
    public void I_run_application()throws Throwable{
        app1CControlService = new mainTread();
        String[] args = {};
        app1CControlService.main(args);
    }

    @Then ("^in Windows Tray add green icon$")
    public void in_Windows_Tray_add_green_icon()throws Throwable{
        String imageName = "Circle_Green.png";
        URL imageUrl = mainTread.class.getResource("Images/" + imageName);
        Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);

        SystemTray systemTray = SystemTray.getSystemTray();
        TrayIcon[] trayApps = systemTray.getTrayIcons();
        int trayIconLeigth = trayApps.length;
        boolean isErrorImage = true;
        if(trayIconLeigth != 0){
            Image trayImage = trayApps[0].getImage();
            if(!trayImage.equals(image)){
                Exception exteptionIcon = new RuntimeException("Иконка в трее не зеленая.");
                throw exteptionIcon;
            }
        }
        else {
            if (isErrorImage) {
                Exception exteptionIcon = new RuntimeException("Иконка в трее не появилась.");
                throw exteptionIcon;
            }
        }
    }

    @Then ("^my application have popup menu of (\\d+) items$")
    public void my_application_have_popup_menu_of_4_items(int itemsCount)throws Throwable{

        SystemTray systemTray = SystemTray.getSystemTray();
        TrayIcon[] trayApps = systemTray.getTrayIcons();
        int trayIconLeigth = trayApps.length;
        boolean isErrorImage = true;
        if(trayIconLeigth != 0){
            PopupMenu popupApp = trayApps[0].getPopupMenu();
            if(popupApp != null){
                if(popupApp.getItemCount() != itemsCount){
                    Exception exteptionIcon = new RuntimeException("У приложения не " + Integer.toString(itemsCount) + " пункта меню");
                    throw exteptionIcon;
                }
            }
            else{
                Exception exteptionIcon = new RuntimeException("У приложения нет меню");
                throw exteptionIcon;
            }
        }
        else {
            if (isErrorImage) {
                Exception exteptionIcon = new RuntimeException("Иконка в трее не появилась.");
                throw exteptionIcon;
            }
        }
    }
}