package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by mac on 08.05.16.
 */
public class ContactHelper  extends HelperBase{


   private NavigationHelper navigationHelper;

   public ContactHelper(WebDriver wd) {

      super(wd);
      navigationHelper = new NavigationHelper(wd);

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

   public void selectContact() {
      click(By.name("selected[]"));
   }

   public void deletedSelectContact(){
      click(By.xpath("//input[@value='Delete']"));
   }

   public void initContactModification(){
      click(By.xpath("(//img[@title='Edit'])[1]"));
   }


   public void updateContactModification(){

      click(By.name("update"));

   }

   public void createContact(ContactData contact) {

      navigationHelper.gotoAddNewContactPage();
      fillContactForm(contact);
      submitContactCreation();
      navigationHelper.gotoHomePage();


   }

   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }
}
