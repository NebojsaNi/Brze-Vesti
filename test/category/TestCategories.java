package category;

import framework.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCategories {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @BeforeClass
    public static void setUpClass() {

        //dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("@BeforeClass: " + dateFormat.format(new Date()));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");

        //WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
        //wait.until(ExpectedConditions.visibilityOf(passwordField));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());

    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("@AfterClass: " + dateFormat.format(new Date()));
        driver.quit();
    }

    @Before
    public void setUp() {
        System.out.println("@BeforeClass: " + dateFormat.format(new Date()));

        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));
        categories.click();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("@AfterClass: " + dateFormat.format(new Date()));
    }

    @Test
    public void testCreateNewCategory() {

        for (int i = 0; i < 5; i++) {
            WebElement addCategoryButton = driver.findElement(By.className("btn"));
            addCategoryButton.click();

            WebElement titleField = driver.findElement(By.id("title"));
            titleField.sendKeys(Helper.getRandomText());

            WebElement saveButton = driver.findElement(By.id("save-category-button"));
            saveButton.click();

            String expectedURL = "http://bvtest.school.cubes.rs/admin/categories";
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("URL se ne poklapa", expectedURL, actualURL);

            String expectedTitle = "Brze vesti admin | Categories ".replaceAll("\\s+", " ").trim();
//            System.out.println("expected title: '" + expectedTitle);
            String actualTitle = driver.getTitle();
//            System.out.println("actual title: '" + actualTitle + "'");
            Assert.assertEquals("Title doesn't match! ", expectedTitle, actualTitle);

        }

        //create new WebDriver and WebDriver wait
        // Fields on Login page found by name locator and explicit wait
    }

    @Test
    public void testEditLastCategory() {

//        WebElement table = driver.findElement(By.id("categoriesTable"));
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement lastRow = rows.get(rows.size() - 1);

        WebElement editButton = lastRow.findElement(By.className("btn-default"));
        editButton.click();

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomText());

        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();

        String expectedURL = "http://bvtest.school.cubes.rs/admin/categories";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals("URL se ne poklapa", expectedURL, actualURL);

        String expectedTitle = "Brze vesti admin | Categories ".replaceAll("\\s+", " ").trim();
//        System.out.println("expected title: '" + expectedTitle);
        String actualTitle = driver.getTitle();
//        System.out.println("actual title: '" + actualTitle + "'");
        Assert.assertEquals("Title doesn't match! ", expectedTitle, actualTitle);

    }

//    @Test
//    public void testDeleteFirstCategory() { da se nadje tbody, obuhvate svi redovi, da kliknem na delete itd, izlazi popup,
    //i mora novi metod
//
//    }
    @Test
    public void testDeleteFirstCategory() {

        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement firstRow = rows.get(0);

        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));
//        WebElement deleteButton = driver.findElement(By.cssSelector("#regionsTable > tbody > tr > td:nth-child(5) > div > button:nth-child(3)"));
deleteButton.click();
    }

}