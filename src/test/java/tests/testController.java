package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testController {
    @Test
    public void testCompra(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("http://automationpractice.com/index.php");
        navegador.findElement(By.xpath("//a[@data-id-product='2']")).click();
        navegador.findElement(By.id("layer_cart")).findElement(By.linkText("Proceed to checkout")).click();

        navegador.findElement(By.linkText("Proceed to checkout")).click();

        navegador.findElement(By.name("email_create")).sendKeys("Rafa776@gft.com.br");

        navegador.findElement(By.id("SubmitCreate")).click();

        navegador.findElement(By.id("id_gender1")).click();

        navegador.findElement(By.id("customer_firstname")).sendKeys("Rafael");

        navegador.findElement(By.id("customer_lastname")).sendKeys("Fernandes");

        navegador.findElement(By.id("passwd")).sendKeys("54321");

        navegador.findElement(By.id("address1")).sendKeys("Rua Otavio, 111");

        navegador.findElement(By.id("city")).sendKeys("Teste");

        navegador.findElement(By.id("id_state")).sendKeys("Massachusetts");

        navegador.findElement(By.id("postcode")).sendKeys("12345");

        navegador.findElement(By.id("id_country")).sendKeys("United States");

        navegador.findElement(By.id("phone_mobile")).sendKeys("11864152665");

        navegador.findElement(By.id("alias")).clear();

        navegador.findElement(By.id("alias")).sendKeys("Boston");

        navegador.findElement(By.id("submitAccount")).click();

        String endereco = navegador.findElement(By.cssSelector("#address_delivery > li.address_address1.address_address2")).getText();

        assertEquals("Rua Otavio, 111", endereco);

        navegador.findElement(By.name("processAddress")).click();

        navegador.findElement(By.id("cgv")).click();

        navegador.findElement(By.name("processCarrier")).click();

        String valorTotal = navegador.findElement(By.cssSelector("#total_price")).getText();

        assertEquals("$29.00", valorTotal);

        navegador.findElement(By.className("cheque")).click();

        navegador.findElement(By.xpath("//span[text()='I confirm my order']")).click();

        String compraFinalizada = navegador.findElement(By.cssSelector("p.alert.alert-success")).getText();
        
        assertEquals("Your order on My Store is complete.", compraFinalizada);

    }
}