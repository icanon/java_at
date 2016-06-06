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
      type(By.name("work"), contactData.getWorkPhone());
      type(By.name("email"), contactData.getEmail());
      type(By.name("email2"), contactData.getEmail2());
      type(By.name("email3"), contactData.getEmail3());
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

   private void openContactViewModeById(int id) {
      click(By.xpath("//a[contains(@href,'" + id + "')]/img[@title='Details']"));
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
         String allPhones = element.findElement(By.xpath("td/input[@id='" + id + "']/../../td[6]")).getText();
         String allEmail = element.findElement(By.xpath("td/input[@id='" + id + "']/../../td[5]")).getText();
         String address = element.findElement(By.xpath("td/input[@id='" + id + "']/../../td[4]")).getText();
         contactCache.add(
                 new ContactData()
                         .withLastName(lastname)
                         .withFirstName(firstname)
                         .withId(id)
                         .withAllPhones(allPhones)
                         .withAddress(address)
                         .withAllEmail(allEmail)
         );
      }
      return new Contacts(contactCache);
   }


   public ContactData infoFromEditForm(ContactData contact) {
      initContactModificationById(contact.getId());
      String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String email1 = wd.findElement(By.name("email")).getAttribute("value");
      String email2 = wd.findElement(By.name("email2")).getAttribute("value");
      String email3 = wd.findElement(By.name("email3")).getAttribute("value");
      String homePhone = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String workPhone = wd.findElement(By.name("work")).getAttribute("value");
      wd.navigate().back();

      return new ContactData().withId(contact.getId())
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAddress(address)
              .withEmail1(email1)
              .withEmail2(email2)
              .withEmail3(email3)
              .withHomePhone(homePhone)
              .withMobile(mobile)
              .withWorkPhone(workPhone);

   }


   public String fillTextName(String name, String index) {

      String content = wd.findElement(By.xpath("//div[@id='content']")).getAttribute("innerHTML");
      String[] parts = content.split("<br>");

      for (int i=0; i<parts.length; i++) {
         if (parts[i].matches("^"+index+": .*")) {
            name = parts[i];
            break;
         }
      }

      return name;
   }


   public ContactData infoFromViewForm(ContactData contact) {

      openContactViewModeById(contact.getId());
      String frstPlusLastName = wd.findElement(By.xpath("//div[@id='content']/b")).getText();
      String emailOnViewForm = wd.findElement(By.xpath("//div[@id='content']/a[contains(@href,'mail')]")).getText();





      String homePhone = fillTextName("homePhone","H");
      String mobilePhone = fillTextName("mobilePhone","M");
      String workPhone = fillTextName("workPhone","W");












     /* for (int i=0; i<parts.length; i++) {
         if (parts[i].matches("^H: .*")) {
            homePhone = parts[i];
            break;
         }
      }*/



//part 0 = имя и фамилия
      //
//      String homePhone = wd.findElement(By.xpath("//div[@id='content']/b/following-sibling::text()[3][contains(text(),'')]")).getText();
//      String mobilePhone = wd.findElement(By.xpath("(//div[@id='content']/b/following-sibling::text())[4]")).getText();
//      String workPhone = wd.findElement(By.xpath("//div[@id='content']/b/following-sibling::text()[5]")).getText();

//      String email1 = wd.findElement(By.xpath("//div[@id='content']/a[contains(@href,'mail')][1]")).getText();
//      String email2 = wd.findElement(By.xpath("//div[@id='content']/a[contains(@href,'mail')][2]")).getText();
//      String email3 = wd.findElement(By.xpath("//div[@id='content']/a[contains(@href,'mail')][3]")).getText();
//      String address = wd.findElement(By.xpath("//div[@id='content']/b/following-sibling::text()[1]")).getText();




      System.out.println();
      System.out.println();
      System.out.println(frstPlusLastName);
      System.out.println(emailOnViewForm);
//      System.out.println(address);
//      System.out.println(homePhone.length() > 0 ? homePhone : "Нету телефона");
//      System.out.println(mobilePhone);
//      System.out.println(workPhone);
//      System.out.println(email1);
//      System.out.println(email2);
//      System.out.println(email3);
      System.out.println();
      System.out.println();

      wd.navigate().back();







      //находит адрес и телефоны
      //div[@id='content']/br/following-sibling::text()

      return null;
   }

}

