package Class4;

import org.testng.annotations.Test;

public class Locators_3 {
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
         * 5. Using the starting portion of attribute-value
         *      //tag[starts-with(@attrName, 'Starting portion of attr-value')]
         *      --> find the tag on dom, where attribute(attrName)'s value starts with "Starting portion of attr-value"
         * eg:
         *      //input[starts-with(@aria-label, 'Ema')]
         *
         *
         * 6. Using the starting portion of text-value
         *      //tag[starts-with(text(), 'Starting portion of text-value')]
         *      --> find the tag on dom, where text-value starts with "Starting portion of text-value"
         * eg:
         *      //a[starts-with(text(), 'Create n')]
         *
         * 7. Using not() method
         *      //tag[not(@attrName='attrValue')]
         *      --> find the tag in dom, where attribute(attrName) has value NOT equals to "attrValue"
         *
         *      //tag[@attrName]
         *      --> find the tag in dom, which has attribute(attrName)
         *
         *      //tag[not(@attrName)]
         *      --> find the tag in dom, which does not have attribute(attrName)
         *
         *      //tag[not(text() = 'Text Value')]
         *      --> find the tag in dom, where text value is NOT equals to "Text Value"
         *
         *      //tag[not(contains(@text(), 'xt Val'))]
         *      --> find the tag in dom, where text value does NOT contain 'xt Val'
         *
         * 8. and/or operator
         *      //tag[@attrName='attr Value' and contains(@attrName2, 'attr2 val')]
         *      //tag(contains(text(), 'Text Val') or starts-with(@attrName, 'Starting Value')]
         * eg:
         *      //button[not(@disabled) and contains(@name, 'Eastern Standard')]
         *
         *
         * //*[@attrName='attr value']
         * --> find any tag in dom, where attribute(attrName) has value equals to "attr value"
         *
         * //*[not(@disabled) and contains(@name, 'Eastern Standard')]
         *
         */

    }
}
