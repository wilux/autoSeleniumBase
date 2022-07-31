package Action;


import Tools.FindLocator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkStatus {
    WebDriver driver;


    public LinkStatus(WebDriver driver) {

        this.driver = driver;


    }


    public boolean verifyImageActive(String strLocator) {

        FindLocator findLocator = new FindLocator(driver);
        By element = findLocator.to(strLocator);


        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(driver.findElement(element).getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean verifyUrlActive(String strLocator) {

        FindLocator findLocator = new FindLocator(driver);
        By element = findLocator.to(strLocator);


        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(driver.findElement(element).getAttribute("href"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}

