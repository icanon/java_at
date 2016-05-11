package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mac on 08.05.16.
 */
public class NavigationHelper extends HelperBase{

   public NavigationHelper(WebDriver wd) {
      super(wd);
   }

   public void gotoGroupPage() {
      click(By.linkText("groups"));
   }

   public void gotoAddNewContactPage() {
      click(By.linkText("add new"));
   }

   public void gotoHomePage(){
      click(By.linkText("home"));
   }
}
