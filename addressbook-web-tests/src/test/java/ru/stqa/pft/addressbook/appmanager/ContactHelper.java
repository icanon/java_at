package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.List;


public class ContactHelper extends HelperBase {


   private NavigationHelper navigationHelper;

   public ContactHelper(WebDriver wd) {

      super(wd);
      navigationHelper = new NavigationHelper(wd);
   }


   public void delete(ContactData contact) {
      selectContactById(contact.getId());
      deletedSelectContact();
      clicAlert();
      contactCache = null;
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
      type(By.name("home"), contactData.getHomePhone());
      type(By.name("email"), contactData.getEmail());
   }

   public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
//      wd.findElement().click();
   }


   private void selectContactById(int id) {
      wd.findElement(By.id("" + id + "")).click();
   }

   public void deletedSelectContact() {
      click(By.xpath("//input[@value='Delete']"));
   }

   public void initContactModification(int before) {
      click(By.xpath("(//img[@title='Edit'])[" + before + "]"));
   }

   private void initContactModificationById(int id) {
      click(By.xpath("//td[@class='center' and preceding-sibling::td[@class='center']/input[@id=" + id + "]]/a/img[@title='Edit']"));
      //click(By.xpath("(//img[@title='Edit'])[" + id + "]"));
      //td[@class="center" and preceding-sibling::td[@class="center"]/input[@id="59"]]/a/img[@title="Edit"]
   }

   public void updateContactModification() {

      click(By.name("update"));

   }

   public void create(ContactData contact) {

      navigationHelper.gotoAddNewContactPage();
      fillContactForm(contact);
      submitContactCreation();
      contactCache = null;
      returnToHomePage();
   }


   public void modify(ContactData contact) {
      initContactModificationById(contact.getId());
      fillContactForm(contact);
      updateContactModification();
      contactCache = null;
      returnToHomePage();
   }


   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }

   public int count() {
      return wd.findElements(By.name("selected[]")).size();
   }


   private Contacts contactCache = null;


   public Contacts all() {
      if (contactCache != null) {
         return new Contacts(contactCache);
      }

      contactCache = new Contacts();
      List<WebElement> elements = wd.findElements(By.name("entry"));
      for (WebElement element : elements) {
         String lastname = element.findElement(By.xpath("td[2]")).getText();
         String firstname = element.findElement(By.xpath("td[3]")).getText();
         int id = Integer.parseInt(element.findElement(By.xpath("*/input[@name='selected[]']")).getAttribute("value"));
         String allphones ;
         //tbody/tr/td/input[@id='61']/../../td[6]


//         ContactData con = new ContactData().withLastName(lastname).withFirstName(firstname).withId(id);
         contactCache.add(new ContactData().withLastName(lastname).withFirstName(firstname).withId(id));
      }
      return new Contacts(contactCache);
   }


   public ContactData infoFromEditForm(ContactData contact) {
      initContactModificationById(contact.getId());
      String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
      String homePhone = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String workPhone = wd.findElement(By.name("work")).getAttribute("value");
      wd.navigate().back();

      return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
              .withHomePhone(homePhone).withMobile(mobile).withWorkPhone(workPhone);
   }
}

