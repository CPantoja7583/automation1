package automation;

import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class VitaWalletTests extends BaseTest {
    @Test
    public void captchatest() {

        final var urlVitaWallet = "https://vitawallet.io/";

        Logs.info("Navegando a : %s", urlVitaWallet);
        driver.get(urlVitaWallet);


    }
}
