package herokuapp.FileUpload_Download;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploader extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement chooseFileButton = driver.findElement(By.cssSelector("input[id='file-upload']"));
        File file = new File("src/main/resources/American_Gothic.jpg");
        chooseFileButton.sendKeys(file.getAbsolutePath());
        WebElement uploadButton = driver.findElement(By.cssSelector(".button"));
        uploadButton.click();
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'File Uploaded!')]")));
        Assert.assertEquals(uploadedFile.getText(), "American_Gothic.jpg");
    }
}
