package e2e;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pages.app.TestBase;
import utils.TestRunner;

@RunWith(TestRunner.class)
public class AppiumTest extends TestBase {
    @Test
    @DisplayName("General Store app")
    @Description("Åpne appen og legg sko til kart")
    public void AppTest() {
        generalStore.velgSted();
        generalStore.velgKjonnOgKjop();
        generalStore.velgSkoOgLeggtilkart();
        generalStore.klikkKart();
    }
}


