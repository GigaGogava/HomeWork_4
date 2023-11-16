import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.conditions.Disabled;
import com.codeborne.selenide.conditions.Enabled;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork_4 {
    private WebElementCondition Enabled;
    private WebElementCondition Disabled;

    @Test
    public void aversiPositiveRegistration() {
        open("https://shop.aversi.ge/ka/profiles-add/");
        $("#elm_6").setValue("Giga");
        $("#elm_7").setValue("Gogava");
        $("#elm_9").setValue("599009999");
        $("#email").setValue("gigagogava23@gmail.com");
        $("#password1").setValue("passWord12.");
        $("#password2").setValue("passWord12.");
        $("#elm_39").setValue("11111111111");
        $("#profile_mailing_list_1").click();
        $(byName("dispatch[profiles.update]")).click();
        sleep(2000);
    }

    @Test
    public void aversiNegativeRegistration() {
        open("https://shop.aversi.ge/ka/profiles-add/");
        $("#elm_6").setValue("Giga");
        $("#elm_7").setValue("Gogava");
        $("#elm_9").setValue("234s");
        $("#email").setValue("123.com");
        $("#password1").setValue("123");
        $("#password2").setValue("123456");
        $(byName("dispatch[profiles.update]")).click();
        $(byName("dispatch[profiles.update]")).shouldNotBe(Condition.disabled);
        $(".help-inline").shouldBe(Condition.visible);   //telefoni
        $("#email_error_message").shouldBe(Condition.visible);  //maili
        $("#password1_error_message").shouldBe(Condition.visible);  //paroli
        $("#password2_error_message").shouldBe(Condition.visible);  //parolis damowmeba
        sleep(3000);
    }

}