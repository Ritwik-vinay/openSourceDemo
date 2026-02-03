package retry;

import org.openqa.selenium.WebDriverException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.TimeoutException;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {
        Throwable exception = result.getThrowable();
        if (exception instanceof TimeoutException ||
                exception instanceof WebDriverException) {
            if (retryCount < MAX_RETRY_COUNT) {
                retryCount++;
                System.out.println(
                        "RetryTest: " + result.getName() +
                                " |Attempt: " + retryCount
                );
                return true;
            }
        }
        return false;
    }
}
