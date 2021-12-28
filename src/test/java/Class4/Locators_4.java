package Class4;

import org.testng.annotations.Test;

public class Locators_4 {
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
         * Advanced Xpath (Indirect xpath):
         *
         * 1. Using parent/grandParent tag
         *      (//table[@class='HZDuax'])[1]//button[text()='25']
         *      //div[@class='selectric-wrapper selectric-units selectric-below']//span[starts-with(text(), '˚F')]
         *      //div[@id='header']//span[starts-with(text(), '˚F')]
         *
         * 2. Xpath Axes:
         *
         *      1. following-sibling
         *      //tag[condition(s)]/following-sibling::tag2[condition(s)]
         *      eg:
         *      //label[text()='Female']/following-sibling::input
         *      //h2[text()='December 2021']/following-sibling::table//button[text()='25']
         *
         *      2. preceding-sibling
         *      //tag[condition(s)]/preceding-sibling::tag2[condition(s)]
         *
         *      3. following
         *      //tag[condition(s)]/following::tag2[condition(s)]
         *      eg:
         *      //a[text()='Create a Page']/following::a[@title='Log into Facebook']
         *
         *      4. preceding
         *      //tag[condition(s)]/preceding::tag2[condition(s)]
         *      eg:
         *      //a[text()='Create a Page']/preceding::button[text()='Log In']
         *
         *      5. ancestor
         *      //tag[condition(s)]/ancestor::tag2[condition(s)]
         *
         *      6. descendant
         *      //tag[condition(s)]/descendant::tag2[condition(s)]
         *
         */

        /**
         * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *     <tag1_1 id="abcd" data-text-id="unique data" attr3="value3" attr4="value4">
         *         <tag1_1_1>Not Unique Text
         *              <subTag attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1>
         *         </tag1_1_1>
         *         <tag1_1_2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1_1_2>
         *              <subTag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag1>
         *
         *              <subTag2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag2>
         *                  <subTag3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag3>
         *
         *         <tag1_1_3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1_1_3>
         *     </tag1_1>
         *     <tag1_2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *         <tag1_2_1 attr1="value1" attr2="value2">Unique Text</tag>
         *     </tag1_2>
         *     <tag1_3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *          <tag1_3_1 attr1="value1" attr2="value2" attr3="value3" attr4="value4"></tag>
         *     </tag1_3>
         * </tag1>
         */






    }
}
