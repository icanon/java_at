package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

   public void initContactModification(int before){
//      wd.findElement(By.xpath("(//img[@title='Edit'])[1]")).get
      click(By.xpath("(//img[@title='Edit'])["+ before +"]"));
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

   public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
   }

   public List<ContactData> getContactList() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.name("entry"));
      for (WebElement element : elements) {
         String lastname = element.findElement(By.xpath("td[2]")).getText();
         String firstname = element.findElement(By.xpath("td[3]")).getText();
         String id = element.findElement(By.xpath("*/input[@name='selected[]']")).getAttribute("value");
         ContactData contact = new ContactData(id, firstname, lastname, null, null, null);
         contacts.add(contact);
      }
      return contacts;
   }
}


//   WebElement lastNameElem = wd.findElement(By.xpath("//td[2]"));
//   WebElement firstNameElem = wd.findElement(By.xpath("//td[3]"));
//   String firstName = firstNameElem.getText();
//   String lastName = lastNameElem.getText();