package relativeLocation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsAciklama {

    public static void main(String[] args) {

        // above
        // input ariyorum, By.id("password")'un üst tarafinda olan input
        By aboveLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));

        // below
        // input ariyorum, By.id("email")'in altinda olan input
        By belowLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));

        // toLeftOf
        // button ariyorum, By.id("submit")'in solunda olan button
        By toTheLeftLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));


        // toRightOf
        // button ariyorum, By.id("cancel")'in ssaginda olan button
        By toTheRightLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));

        // near
        // input ariyorum, By.id("email")'in en fazla 50px yakininda olan input
        By nearLocator = RelativeLocator.with(By.tagName("input")).near(By.id("email"));

        // Zincirleme Relative Locators
        // button ariyorum, By.id("email")'in alt kisminda, By.id("cancel")'in sag tarafinda
        By chainLocator = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));
    }
}
