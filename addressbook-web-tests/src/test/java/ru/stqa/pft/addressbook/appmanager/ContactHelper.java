package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper  extends HelperBase{


   private NavigationHelper navigationHelper;

   public ContactHelper(WebDriver wd) {

      super(wd);
      navigationHelper = new NavigationHelper(wd);
   }



   public void delete(ContactData contact) {
      selectContactById(contact.getId());
      deletedSelectContact();
      clicAlert();
      returnToHomePage();
   }

   public void returnToHomePage() {
      click(By.linkText("home"));
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


   private void selectContactById(int id) {
      wd.findElement(By.id(""+id+"")).click();
   }

   public void deletedSelectContact(){
      click(By.xpath("//input[@value='Delete']"));
   }

   public void initContactModification(int before){
      click(By.xpath("(//img[@title='Edit'])[" + before + "]"));
   }

   private void initContactModificationById(int id) {
      click(By.xpath("//td[@class='center' and preceding-sibling::td[@class='center']/input[@id="+id+"]]/a/img[@title='Edit']"));
//      click(By.xpath("(//img[@title='Edit'])[" + id + "]"));

      //td[@class="center" and preceding-sibling::td[@class="center"]/input[@id="59"]]/a/img[@title="Edit"]
   }

   public void updateContactModification(){

      click(By.name("update"));

   }

   public void create(ContactData contact) {

      navigationHelper.gotoAddNewContactPage();
      fillContactForm(contact);
      submitContactCreation();
      returnToHomePage();
   }


   public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    updateContactModification();
    returnToHomePage();
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
         int id = Integer.parseInt(element.findElement(By.xpath("/*input[@name='selected[]']")).getAttribute("value"));
         ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname);
         contacts.add(contact);
      }
      return contacts;
   }

   public Set<ContactData> all() {
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
   }

}

