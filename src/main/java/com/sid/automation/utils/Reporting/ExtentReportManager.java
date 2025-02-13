package com.sid.automation.utils.Reporting;

    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
    
    public class ExtentReportManager {
        private static ExtentReports extent;
        private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
    
        // Initialize Extent Reports
        public static void initReports() {
            if (extent == null) {  // Initialize only once
                String reportPath = System.getProperty("user.dir") + "/extent-reports/ExtentReport.html";
                ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
                extent = new ExtentReports();
                extent.attachReporter(reporter);
                extent.setSystemInfo("Tester", "SiddheshwarDongare");
            }
        }
    
        // Create a new test in the report
        public static void createTest(String testName) {
            if (extent == null) {
                initReports();  // Ensure reports are initialized
            }
            ExtentTest test = extent.createTest(testName);
            testThreadLocal.set(test);
        }
    
        // Get the current test instance
        public static ExtentTest getTest() {
            return testThreadLocal.get();
        }
    
        // Flush the report at the end
        public static void flushReports() {
            if (extent != null) {
                extent.flush();
            }
        }
    }