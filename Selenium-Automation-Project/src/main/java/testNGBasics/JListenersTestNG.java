package testNGBasics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class JListenersTestNG implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Start of Test case");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success/Pass");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Test Success Perecentage");
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("On Test failure due to timeout");
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start of everything");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish of everything");
		ITestListener.super.onFinish(context);
	}


}
