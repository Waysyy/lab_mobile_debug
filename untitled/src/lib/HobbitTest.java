//package lib;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.URL;
//
//public class HobbitTest extends TestCase {
//        private AppiumDriver driver;
//        private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
//
//        public void setUp() throws Exception{
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("deviceName", "OnePlus Nord 3 5G");
//            capabilities.setCapability("platformVersion", "14.0");
//            capabilities.setCapability("automationName", "Appium");
//            capabilities.setCapability("appPackage", "org.wikipedia");
//            capabilities.setCapability("appActivity", ".main.MainActivity");
//            capabilities.setCapability("app", "C:\\Users\\Waysy\\IdeaProjects\\untitled\\apks\\org.wikipedia.apk");
//            driver = new AndroidDriver(new URL(AppiumURL), capabilities);
//
//        }
//
//
//        public void tearDown(){
//            driver.quit();
//        }
//
//        @Override
//        protected void setUp() throws Exception{
//            super.setUp();
//        }
//        @Override
//        protected void tearDown() throws  Exception{
//            driver.quit();
//            super.tearDown();
//    }
//}
