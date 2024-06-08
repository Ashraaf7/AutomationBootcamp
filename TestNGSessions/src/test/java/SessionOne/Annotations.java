package SessionOne;

import org.testng.annotations.*;

@Test
public class Annotations {

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test");

    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before Method");
    }


    public void testCase1 ()
    {
        System.out.println("Test Case 1");
    }

    public void testCase2 ()
    {
        System.out.println("Test Case 2");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("After Test");

    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After Method");
    }



}
