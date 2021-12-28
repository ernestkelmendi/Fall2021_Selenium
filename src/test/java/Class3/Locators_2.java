package Class3;

import org.testng.annotations.Test;

public class Locators_2 {
    @Test
    public void UseLocators() {

        /**
         * ChroPath Plugin:
         * https://chrome.google.com/webstore/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo?hl=en
         */

        /**
         * Locator : It's a kind of data/route to find desired webElement
         * Datatype of Locator -> By
         *
         *
         * Steps to create Locator
         * 1. Find the unique address to reach to the webElement using DOM
         * 2. Depending upon the type of address/info,
         *      we use specific method from By-Class to create locator
         * 3. Use locator to find the WebElement (use: findElement() method)
         * 4. when WebElement is found, interact with it.
         *
         * Address:
         * 1. id attribute (unique)
         *      In chropath, check if id-value is unique --> //*[@id='idValue']
         *      By locatorUsingId = By.id("idValue");
         *
         *      eg:
         *      By loginEmailLocator = By.id("email");
         *
         * 2. name attribute
         *      In chropath, check if name-value is unique --> //*[@name='nameValue']
         *      By locatorUsingName = By.name("nameValue")
         *
         *      eg:
         *      By loginPasswordLocator = By.name("pass");
         *
         * 3. tagName
         *      In chropath, check if tagName is unique --> //tagName
         *      By locatorUsingTagName = By.tagName("tagNameValue")
         *
         *      eg:
         *      By loginButtonLocator = By.tagName("button")
         *
         * 4. class attribute
         *      In chropath, check if class-value is unique --> //*[@class='classValue']
         *      By locatorUsingClassName = By.className("classValue");
         *
         * 5. linkText
         *      In chropath, check if link-text-value is unique --> //a[text()='Link Text Value']
         *      By locatorUsingLinkText = By.linkText("link text value");
         *
         * 6. partialLinkText
         *      In chropath, check if partial link-text-value is unique --> //a[contains(text() , "Link Tex")]
         *      By locatorUsingPartialLinkText = By.partialLinkText("Link Tex")
         *
         * 7. Xpath
         *
         *      By locatorUsingXpath = By.xpath("//xpath to find webElement")
         *
         *
         */

        /**
         * Links:
         *      1. Always with 'a' tag
         *      2. Text associated with link(or a-tag) is known as LinkText
         *      3. the value of "href" attribute defines where user will lands after clicking the link.
         */

        /**
         * XPATH
         *
         * Types:
         * 1. Absolute Xpath
         *      a) starts with single slash (/)
         *      b) tells the route to reach to a particular webElement from the root tag (or html tag)
         *      c) not reliable, any change in the webPage can break the absolute-xpath.
         *
         * 2. Relative Xpath
         *      a) starts with double slash (//)
         *      b) reliable bcz we use the tag-Name, attributes, text-Value or any of them in combination
         *
         *      -> simple xpath (direct xpath)
         *      -> advanced xpath (indirect xpath)
         *
         */

        /**
         * Simple xpath (direct xpath)
         *
         * 1. Using attribute value:
         *      //tag[@attrName='attr Value']
         *      --> find the tag in dom, where attribute(attrName) has value equals to "attr Value"
         * eg:
         *      //div[@data-hover='tooltip']
         *
         * 2. Using text value:
         *      //tag[text()='webElement text value']
         *      --> find the tag in dom, where text value is equals to "webElement text value"
         * eg:
         *      //button[text()='Log In']
         *
         * 3. Using partial attribute value:
         *      //tag[contains(@attrName , 'attr Val')]
         *      --> find the tag in dom, where attribute(attrName)'s value contains "attr Val"
         * eg:
         *      //button[contains(@data-testid , 'royal_login')]
         *
         * 4. Using partial text value:
         *      //tag[contains(text() , 'Text Val')]
         *      --> find the tag in dom, where text-value contains "Text Val"
         * eg:
         *      //button[contains(text() , 'Log')]
         */

    }
}
