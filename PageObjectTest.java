package dz_test_lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import dz_lesson_6.ExpensesSubMenu;
import dz_lesson_6.LoginView;
import dz_lesson_6.MainView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get("https://crm.geekbrains.space");
    }

    @Test
    void loginTest() throws InterruptedException {
        new LoginView(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2022!")
                .submitLogin()
                .navigationMenu.openNavigationSubMenuItems("Расходы");

        new MainView(webDriver).navigationMenu.openNavigationSubMenuItems("Расходы");
        new ExpensesSubMenu(webDriver).expensesButtonClick();
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

}
