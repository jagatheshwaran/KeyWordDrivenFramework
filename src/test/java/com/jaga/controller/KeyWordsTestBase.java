package com.jaga.controller;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jaga.utils.Resources;

public class KeyWordsTestBase extends Resources {

	// Resources resources = new Resources();

	/**
	 * This Method will return web element.
	 * 
	 * @param locator
	 * @return WebElement
	 * @throws Exception
	 */
	public WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return getDriver().findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return getDriver().findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return getDriver().findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return getDriver().findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return getDriver().findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return getDriver().findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return getDriver().findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return getDriver().findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	/**
	 * This Method will return list of web element.
	 * 
	 * @param locator
	 * @return WebElement
	 * @throws Exception
	 */
	public List<WebElement> getLocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return getDriver().findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return getDriver().findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return getDriver().findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return getDriver().findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return getDriver().findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return getDriver().findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return getDriver().findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return getDriver().findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public WebElement getWebElement(String locator) throws Exception {
		System.out.println("locator data:-" + locator + "is---" + getObjectRepository().getProperty(locator));
		return getLocator(getObjectRepository().getProperty(locator));
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(getObjectRepository().getProperty(locator));
	}

	public String navigate() {
		System.out.println("Navigate is called..");
		try {
			getDriver().navigate().to("WebElement");
		} catch (Exception ex) {
			return "FAIL - Element not found - " + WebElement;
		}
		return "PASS";
	}

	public String selectRadioButton() {
		System.out.println("Select RadioButton is called..");
		try {
			getWebElement(WebElement).click();
		} catch (Exception ex) {
			return "FAIL - Element not found - " + WebElement;
		}
		return "PASS";
	}

	public String enterText() {
		System.out.println("Enter Text is called..");
		try {
			getWebElement(WebElement).sendKeys(TestData);
		} catch (Exception ex) {
			return "FAIL - Element not found - " + WebElement;
		}
		return "PASS";
	}

	public String verifyElementText() {
		System.out.println("Verify Element Text is called..");
		try {
			String actualText = getWebElement(WebElement).getText();
			System.out.println("Actual WebElement Text : " + actualText);
			if (!actualText.equals(TestData)) {
				return "FAIL - Actual webelement text is " + actualText + "is not equal to expected text " + TestData;
			}
		} catch (Exception ex) {
			return "FAIL - Element not found - " + WebElement;
		}
		return "PASS";
	}

	public String verifyAppText() {
		System.out.println("Verify App Element Text is called");
		try {
			String actualText = getWebElement(WebElement).getText();
			if (!actualText.equals(getAppText().getProperty(WebElement))) {
				return "Failed - Actual text " + actualText + " is not equal to to expected text "
						+ getAppText().getProperty(WebElement);
			}
		} catch (Throwable ex) {
			return "FAIL - Element not found - " + WebElement;
		}
		return "PASS";
	}

	public String explicitWait() throws Exception {
		System.out.println("Explicit Wait is called..");
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(ExpectedConditions.visibilityOf(getWebElement(WebElement)));
		} catch (Throwable ex) {
			return "FAIL - Unable to wait for webelement visibility";
		}
		return "PASS";
	}

	public String waitFor(int timeOut) {
		System.out.println("Wait For is called");
		try {
			Thread.sleep((timeOut + 1) * 500);
		} catch (InterruptedException ex) {
			return "FAIL - unable to load the page";
		}
		return "PASS";
	}

	public String clickElementWhenReady() {
		System.out.println("Click Element When Ready is called..");
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(ExpectedConditions.elementToBeClickable(getWebElement(WebElement)));
			getWebElement(WebElement).click();
		} catch (Exception ex) {
			return "FAIL - unable to wait for webelement to become clickable";
		}
		return "PASS";

	}

}
