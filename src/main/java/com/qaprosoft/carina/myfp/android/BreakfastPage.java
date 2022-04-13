package com.qaprosoft.carina.myfp.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.myfp.common.AddFoodPageBase;
import com.qaprosoft.carina.myfp.common.BreakfastPageBase;
import com.qaprosoft.carina.myfp.utils.constants.TextConstants;
import com.qaprosoft.carina.myfp.utils.constants.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BreakfastPageBase.class)
public class BreakfastPage extends BreakfastPageBase implements TimeConstants, IMobileUtils, TextConstants {

    public BreakfastPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/searchEditTextOld")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='FoodSearchActivityV2']/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private ExtendedWebElement listOfSearchedFoods;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/itemWithHeaderContainer' and @index='0']")
    private ExtendedWebElement chosenFood;

    @Override
    public void typeFood(String food) {
        searchField.click();
        searchField.type(food);
    }

    @Override
    public void clickOnSearchedFoodList() {
        listOfSearchedFoods.click(FIVE_SECONDS);
    }

    @Override
    public AddFoodPageBase clickOnChosenFood() {
        chosenFood.click(THREE_SECONDS);
        waitUntil(ExpectedConditions.visibilityOf(chosenFood.getElement()), TEN_TIMEOUT);
        return initPage(getDriver(), AddFoodPageBase.class);
    }
}