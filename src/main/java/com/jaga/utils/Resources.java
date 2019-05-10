package com.jaga.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.jaga.excelreader.ExcelReader;

public class Resources {

	private WebDriver driver;
	private Properties objectRepository = new Properties();
	private Properties config = new Properties();
	private Properties appText = new Properties();
	public ExcelReader SuiteData;
	public ExcelReader TestStepData;

	public String Keyword;
	public String TestData;
	public String WebElement;
	public String TestDataField;
	public String ProceedOnFail;
	public String TSID;
	public String Description;
	public File file;
	public FileInputStream fileInputStream;

	public String suiteDataPath = "//src//test//resources//TestData//TestSuite1Data.xlsx";
	public String testStepDataPath = "//src//test//resources//TestData//TestSuite1.xlsx";
	public String objectRepoPath = "//src//main//resources//CofigurationFiles//Object.properties";

	public void initialize() throws IOException {

		SuiteData = new ExcelReader(System.getProperty("user.dir") + suiteDataPath);
		TestStepData = new ExcelReader(System.getProperty("user.dir") + testStepDataPath);

		file = new File(System.getProperty("user.dir") + objectRepoPath);
		fileInputStream = new FileInputStream(file);
		getObjectRepository().load(fileInputStream);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Properties getObjectRepository() {
		return objectRepository;
	}

	public void setObjectRepository(Properties objectRepository) {
		this.objectRepository = objectRepository;
	}

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public Properties getAppText() {
		return appText;
	}

	public void setAppText(Properties appText) {
		this.appText = appText;
	}

}
