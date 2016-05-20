package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData("11111", "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("222",
              "2222", "22222", "+799999999999", "222222@2222.ru"));
      app.getContactHelper().updateContactModification();
      app.getNavigationHelper().gotoHomePage();

   }
}
