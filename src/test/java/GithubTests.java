import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {
    @Test
    void softAssertionsSearchTest() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("button[class*='btn-link']").scrollTo().click();
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                    @Test
                    void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                    }
                } 
                """));
    }
}
