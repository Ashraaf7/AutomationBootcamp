import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {
    @BeforeClass
    public void register()
    {
        Utility.injectRequest();
    }

    @Test
    public void login()
    {

    }
}
