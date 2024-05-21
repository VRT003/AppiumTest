package e2e;

import org.junit.Test;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pages.app.TestBase;

public class AppiumTest extends TestBase {

    @Test
    @DisplayName("General Store app")
    @Description("Åpne appen")
    @Step("Åpne General store app")
    public void AppTest() {
        generalStore.Testflow();
    }


}


