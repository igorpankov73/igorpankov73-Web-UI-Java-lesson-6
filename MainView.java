package dz_lesson_6;

import org.openqa.selenium.WebDriver;

public class MainView extends BaseView {
    public NavigationMenu navigationMenu;

    public MainView(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(webDriver);
    }
}
