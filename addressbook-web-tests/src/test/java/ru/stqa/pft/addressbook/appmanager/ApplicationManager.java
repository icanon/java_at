package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by mac on 08.05.16.
 */
public class ApplicationManager {
   WebDriver wd;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;
   private String browser;

   public ApplicationManager(String browser) {
      this.browser = browser;
   }


   public void init() {
      if (browser == BrowserType.FIREFOX) {
         wd = new FirefoxDriver();
      } else if (browser == BrowserType.CHROME) {
         wd = new ChromeDriver();
      } else if (browser == BrowserType.IE) {
         wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/group.php");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      sessionHelper = new SessionHelper(wd);
      contactHelper = new ContactHelper(wd);
      sessionHelper.login("admin", "secret");


   }



   public void stop() {
      wd.quit();
   }

   public GroupHelper group() {
      return groupHelper;
   }

   public NavigationHelper goTo() {
      return navigationHelper;
   }

   public ContactHelper contact() {
      return contactHelper;
   }

}
