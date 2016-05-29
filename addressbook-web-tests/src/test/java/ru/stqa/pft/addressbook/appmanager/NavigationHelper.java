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

   public void groupPage() {
      if (isElementPresent(By.xpath("//div/h1[contains(text(),'Groups')]"))
              &&  wd.findElement(By.xpath("//h1[contains(text(),'Groups')]")).getText().equals("Groups")
              && isElementPresent(By.name("new"))) {
         return;
      }
      click(By.linkText("groupssss"));
   }

   public void gotoAddNewContactPage() {
      click(By.linkText("add new"));
   }

   public void homePage(){
      if (isElementPresent(By.id("maintable"))){
         return;
      }
      click(By.linkText("home"));
   }
}
