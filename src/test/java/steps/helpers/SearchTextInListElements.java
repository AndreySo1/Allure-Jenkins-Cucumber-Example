package steps.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTextInListElements {
    public static boolean searchRegistr(List<SelenideElement> list, String searchData, boolean logicEvery){
        /**
         * if logicEvery==true same logic && (return true if EVERY element contain searchData)
         * if logicEvery==false same logic || (return true if AT LEAST element contain searchData)
         */
        boolean result = false;
        if(list.size()==0) return false;
        String myStr = searchData.substring(0, 1).toUpperCase() + searchData.substring(1);

        for(SelenideElement element : list){
            String text = element.getText();
            if(text.matches("^.*"+searchData+".*$") ||
                    text.matches("^.*(" + myStr+").*$") ||
                    text.matches("^.*(" + searchData.toUpperCase()+").*$")){
                result = true;
                if(!logicEvery) return true;
            } else {
                if(logicEvery) return false;
            }
        }

        return result;
    }
}
