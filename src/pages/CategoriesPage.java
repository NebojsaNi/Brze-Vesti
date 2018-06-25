package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {

    public void clickOnAddCategoryButton(WebDriver driver) {

        WebElement addCategoryButton = driver.findElement(By.className("btn"));
        addCategoryButton.click();

    }

    public void enterTitleField(WebDriver driver) {

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
    }

    public void clickOnSaveCategoryButton(WebDriver driver) {

        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
    }

    public void addNewCategory(WebDriver driver) {

        clickOnAddCategoryButton(driver);
        enterTitleField(driver);
        clickOnSaveCategoryButton(driver);

    }

    public List<WebElement> getRowsFromTable(WebDriverWait wait) {
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    public WebElement chooseLastRow(WebDriverWait wait) {

        List<WebElement> rows = getRowsFromTable(wait);
//        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
//        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
//
//        System.out.println("Number of rows: " + rows.size());
//
//        WebElement lastRow = rows.get(rows.size() - 1);
//
//        return lastRow;
        return rows.get(rows.size() - 1);

    }

    public WebElement chooseFirstRow(WebDriverWait wait) {
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement firstRow = rows.get(0);

//        return firstRow;
        return getRowsFromTable(wait).get(0);

    }

    public WebElement chooseRandomRow(WebDriverWait wait) {
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement randomRow = rows.get(0);
//List<WebElement> rows = getRowsFromTable(wait);
//WebElement randomRow = rows.get(Helper.(rows.size()));
        return randomRow;
//List<WebElement> rows = getRowsFromTable(wait);
//WebElement randomRow = rows.get(Helper.(rows.size()));
        


    }

    public void clickOnEditButton(WebElement row) {

        WebElement editButton = row.findElement(By.className("btn-default"));
        editButton.click();

    }

    public void sendTextOnTitleFieldWithClear(WebDriver driver) {

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomText());

    }

    public void editLastCategory(WebDriver driver, WebDriverWait wait) {
        //        WebElement table = driver.findElement(By.id("categoriesTable"));

        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);

    }

    public void editFirstCategory(WebDriver driver, WebDriverWait wait) {

        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);

    }
    
     public void editRandomCategory(WebDriver driver, WebDriverWait wait) {

        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(RandomRow);
        sendTextOnTitleFieldWithClear(driver);
        clickOnSaveCategoryButton(driver);

    }
     
      public void clickOnDeleteButton(WebElement row) {

       row.findElement(By.cssSelector("button[title='Delete']")));
        editButton.click();

    }
      
      public void clickOnConfirmDeleteButton();
      
      

    public void deleteFirstCategory(WebDriver driver, WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow(wait);
        clickOnDeleteButton(firstRow);
        

    }
     
     

}
