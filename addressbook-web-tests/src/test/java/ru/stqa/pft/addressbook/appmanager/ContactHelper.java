package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by mac on 08.05.16.
 */
public class ContactHelper  extends HelperBase{

   public ContactHelper(FirefoxDriver wd) {
      super(wd);

      this.wd = wd;
   }

   public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"), contactData.getFirstName());
      type(By.name("lastname"), contactData.getLastName());
      type(By.name("address"), contactData.getAddress());
      type(By.name("mobile"), contactData.getMobile());
      type(By.name("email"), contactData.getEmail());
   }

   public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
//      wd.findElement().click();
   }

}
