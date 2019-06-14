package CommonPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.becow.ui.SellerPageUI;

public class commonFunction extends BasePage {
	public commonFunction(WebDriver driver) {
		super(driver);
	}

	private int timeouts = 20;

	public void openUrl(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void fowardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public String getText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public void clear(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void input(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectComboboxByVisibleText(String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}

	public void selectComboboxByValue(String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByValue(value);
	}

	public String getTextComboboxSelected(String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();

	}

	public String getAtribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public int getSizeList(String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		return list.size();
	}

	public boolean isDisplayed(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isDisplayed(String locator, String... value) {
		String dynamicLocator = String.format(locator, (Object[]) value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	public boolean isSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnabled(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void inputAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	public String getWindow() {
		return driver.getWindowHandle();
	}

	public void switchToIframe(String locator) {
		driver.switchTo().frame(locator);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void hover(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	public void rightClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(element);
		action.build().perform();
	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

	public void clickAndHold(String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}

	public void inputKeys(String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);

	}

	public void uploadBySendKeys(String locator, String value) {
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.sendKeys(value);
	}

	public void uploadByRobot(String locator, String value) throws Exception {
		StringSelection select = new StringSelection(value);
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.click();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void executeScriptBrowser(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}

	public String getTextjQuery(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(javaScript).toString();
	}

	public void clickByJavascript(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToBottomPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void highlight(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style='border: 2px solid; border-color: red'", element);
	}

	public void removeAttribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void waitPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Create random email
	public static String randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(9999999);
		return String.valueOf(number);
	}

	public void waitProgressBar(final String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}

	public void waitVisibleDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
	}

	public void inputDynamicElement(String locator, String value, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.sendKeys(value);
	}

	public String gettextDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.getText();
	}

	public void clickDynamicElement(String locator, String... dynamic) {
		String dynamicLocator = String.format(locator, (Object[]) dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	public void clickRandomCombobox(String locator) {
		List<WebElement> selects = driver.findElements(By.xpath(locator));
		Random rand = new Random();
		int list = rand.nextInt(selects.size());
		selects.get(list).click();
	}

	public boolean verifyElement() {
		Boolean isPresent = driver.findElements(By.xpath(SellerPageUI.CAT3)).size() > 0;
		return isPresent;
	}

	public void inputNum(String locator, int value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(Integer.toString(value));
	}

	public void hoverProductName(String locator) {
		WebElement hoverElement = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).perform();

	}

}
