import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiOne {
    @Test
    void softAssertionsSearchTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").find(byText("Soft assertions")).shouldHave(text("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
