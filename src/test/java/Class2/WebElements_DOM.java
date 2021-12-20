package Class2;

public class WebElements_DOM {
    /**
     * Types of WebElements:
     *      TextBox/InputBox    ->  type, clear
     *      Button              ->  click
     *      Radio Buttons       ->  click
     *      CheckBox            ->  click
     *      Dropdown            ->  click
     *      Links               ->  click
     *      Image               ->  click, get-text-from-image
     *      Text
     *      Alert
     *      Frames
     */

    /**
     *  DOM -> Document Object Model
     *
     *  code -> generates DOM -> DOM creates the website
     *
     *  <html>
     *      <head></head>
     *      <body></body>
     *  </html>
     *
     *
     *  <tag1>   --> starting of tag1   (Note: tag-names cannot have spaces)
     *
     *  </tag1>   --> closing of tag1
     *
     *  eg: html, head, body, script, div, input, form
     *
     */

    /**
     * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4 attr5="value5">      (Note: attributes-names cannot have spaces)
     *  attr1, attr2, attr3, attr4, attr5 --> attributes of tag1                     (Note: attribute may or may not have a value)
     *
     * eg: <input type="hidden" name="jazoest" value="21032" autocomplete="off">
     *   type, name, value, autocomplete are attributes of input-tag
     *
     *
     * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4 attr5="value5">myText</tag1>
     *      --> tag1 has text-value = myText
     *
     * eg:
     * <button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_d_s9">
     *      "Log In"
     * </button>
     *      --> button-tag has text-value = "Log In"
     *
     *
     * <tag1 attr11="val1" attr12="val2" attr13>
     *     <tag2 attr21="val21" attr22="val22">
     *         text value
     *     </tag2>
     *     <tag3>
     *         text value again
     *     </tag3>
     *      text data
     * </tag1>
     *
     * text with tag2 -> text value
     * text with tag3 -> text value again
     * text with tag1 -> text data
     *
     * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *     <tag2 id="abcd" data-text-id="unique data" attr3="value3" attr4="value4">
     *         <tag3>Not Unique Text
     *              <subTag attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag>
     *         </tag3>
     *         <tag11 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag11>
     *         <tag21 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag21>
     *     </tag2>
     *     <tag4 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *         <a attr1="value1" attr2="value2">Unique Text</tag>
     *     </tag4>
     *     <tag6 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *          <tag7 attr1="value1" attr2="value2" attr3="value3" attr4="value4"></tag>
     *     </tag6>
     * </tag1>
     *
     * children of tag1 --> tag2, tag4, tag6
     *
     * sibling of tag11 --> tag3 and tag21
     *
     * parent of subTag --> tag3
     *
     * siblings of subTag --> 0
     *
     * following-sibling (siblings-tags appearing in dom after the tag)
     * following-sibling of tag11 --> tag21
     * following-sibling of tag3 --> tag11, tag21
     *
     * preceding-sibling (siblings-tags appearing in dom before the tag)
     * preceding-sibling of tag3 --> 0
     * preceding-sibling of tag11 --> tag3
     *
     * following (tags in the dom appearing after the tag)
     * following of tag3 --> subTag, tag11, tag21, tag4, a, tag6, tag7
     * following of tag2 --> tag3, subTag, tag11, tag21, tag4, a, tag6, tag7
     *
     * preceding (tags in the dom appearing before the tag)
     * preceding of a --> tag4, tag21, tag11, subTag, tag3, tag2, tag1
     *
     * descendant (tags in family chain in dom after the tag)
     * descendant of tag3 --> subTag
     * descendant of tag2 --> tag3, subTag, tag11, tag21
     *
     * ancestor (tags in family chain in dom before the tag)
     * ancestor of a --> tag4, tag1
     * ancestor of subTag --> tag3, tag2, tag1
     *
     */
}
