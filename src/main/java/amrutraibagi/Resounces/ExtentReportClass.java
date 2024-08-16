package amrutraibagi.Resounces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	
	public static ExtentReports getReportObject() {
		
		// ExtentReports & ExtentSparkReporter impotent class for creating Extent Report
				String path = System.getProperty("user.dir") + "\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");

				// ExtentReports is main class and the ExtentSpartReporter report is attached to
				// ExtentReports main class
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Amrut Raibagi");
				return extent;
	}

}
