package demo;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase Start : "+result.getName());
        System.out.println("************************************************************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase End : "+result.getName());
        System.out.println("************************************************************************************************************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase Failed : "+result.getName());
        System.out.println("************************************************************************************************************");
    }
}
