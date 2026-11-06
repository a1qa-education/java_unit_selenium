package tests;

import org.testng.annotations.Test;

public class DemoTest extends BaseTest {
    private static final String LOGIN_URL = URL + "login";
    private static final String LOGIN_BUTTON_LOCATOR = "//*[contains(@class,'sign-in')]";
    private static final String ERROR_MESSAGE_ID = "flash";

    @Test
    public void unsuccessfulLoginTest() {

    }
}
