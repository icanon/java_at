package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mac on 08.05.16.
 */
public class ContactHelper  extends HelperBase{


   private NavigationHelper navigationHelper;

   public ContactHelper(WebDriver wd) {

      super(wd);
      navigationHelper = new NavigationHelper(wd);

   }



   public void delete(int index) {
      selectContact(index);
      deletedSelectContact();
      clicAlert();
   }


   public void delete(ContactData contact) {
      selectContactById(contact.getId());
      deletedSelectContact();
      clicAlert();
   }

   public void returnToHomePage() {
      click(By.linkText("home page"));
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

   public void selectContact(int index) {
      wd.findElements(By.name("selected[]")).get(index).click();
   }


   private void selectContactById(int id) {
      wd.findElement(By.id(""+id+"")).click();
   }

   public void deletedSelectContact(){
      click(By.xpath("//input[@value='Delete']"));
   }

   public void initContactModification(int before){
//      wd.findElement(By.xpath("(//img[@title='Edit'])[1]")).get
      click(By.xpath("(//img[@title='Edit'])[" + before + "]"));
   }


   public void updateContactModification(){

      click(By.name("update"));

   }

   public void create(ContactData contact) {

      navigationHelper.gotoAddNewContactPage();
      fillContactForm(contact);
      submitContactCreation();
      navigationHelper.homePage();
   }


   public void modify(int index, ContactData contact) {
    initContactModification(index);
    fillContactForm(contact);
    updateContactModification();
    navigationHelper.homePage();
   }

   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }

   public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
   }

   public List<ContactData> list() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.name("entry"));
      for (WebElement element : elements) {
         String lastname = element.findElement(By.xpath("td[2]")).getText();
         String firstname = element.findElement(By.xpath("td[3]")).getText();
         int id = Integer.parseInt(element.findElement(By.xpath("*/input[@name='selected[]']")).getAttribute("value"));
         ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname);
         contacts.add(contact);
      }
      return contacts;
   }

   public Set<ContactData> all() {
//      List<ContactData> contacts = new ArrayList<ContactData>();
      Set<ContactData> contacts = new HashSet<ContactData>();
      List<WebElement> elements = wd.findElements(By.name("entry"));
      for (WebElement element : elements) {
         String lastname = element.findElement(By.xpath("td[2]")).getText();
         String firstname = element.findElement(By.xpath("td[3]")).getText();
         int id = Integer.parseInt(element.findElement(By.xpath("*/input[@name='selected[]']")).getAttribute("value"));
         ContactData con = new ContactData().withLastName(lastname).withFirstName(firstname).withId(id);
         contacts.add(con);
      }
      return contacts;

//      return new HashSet<ContactData>();
   }
}

