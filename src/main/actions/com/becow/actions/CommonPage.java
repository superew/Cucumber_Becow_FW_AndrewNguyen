package com.becow.actions;

import org.openqa.selenium.WebDriver;

import com.becow.ui.CommonPageUI;
import com.becow.ui.HomePageUI;

import CommonPage.commonFunction;

public class CommonPage extends commonFunction {

	public CommonPage(WebDriver driver) {
		super(driver);
	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(CommonPageUI.DYNAMIC_MSG, value);
		return gettextDynamicElement(CommonPageUI.DYNAMIC_MSG, value);

	}

	public boolean isDisplayed(String value) {
		waitVisibleDynamicElement(CommonPageUI.DYNAMIC_MSG, value);
		return isDisplayed(CommonPageUI.DYNAMIC_MSG, value);
	}

//	public void openDynamicPage(String dynamic) {
//		waitVisibleDynamicElement(HomePageUI.DYNAMIC_LINK, dynamic);
//		clickDynamicElement(HomePageUI.DYNAMIC_LINK, dynamic);
//	}

}
