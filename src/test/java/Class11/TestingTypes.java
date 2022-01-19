package Class11;

public class TestingTypes {
    /**
     *
     * BDD -> Behaviour Driven Development (Cucumber)
     *
     * DDT -> Data Driven Testing
     *      If a scenario/testcases is executing more than once with different set of data
     *
     *      Verify user can invest in gold
     *      Verify user can invest in crypto
     *      Verify user can invest in stocks
     *
     * TDD -> Test Driven Development
     *      Testcases define if the development is done or not
     *
     Scenario: Verify user gets error for invalid credential
     When I enter '%^&&*()' as login email
     When I enter 'abcd@1234' as login password
     When I click on login button
     Then I verify login error is displayed
     *
     *
     * How to we perform Data Driven testing (DDT) in Cucumber
     * --> using Scenario Outline and Examples
     *
     *
     */

}
