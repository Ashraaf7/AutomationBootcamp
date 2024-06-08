package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Iretry implements IRetryAnalyzer {
    private int attemps = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.getStatus()==ITestResult.FAILURE && attemps==0) //1
        {
            attemps++;
            return true;
        }
        return false;
    }
}
