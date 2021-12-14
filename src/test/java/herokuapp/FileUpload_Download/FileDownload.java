package herokuapp.FileUpload_Download;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends BaseTest {

    @Test
    public void fileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        String fileName = "American_Gothic.jpg";
        WebElement downloadLink = driver.findElement(By.cssSelector("a[href='download/"+fileName+"']"));
        downloadLink.click();
        wait.until(
                (ExpectedCondition<Boolean>) driver ->
                        Files.exists(Paths.get(testDownloadsDir + File.separator + fileName))
        );
    }
}
