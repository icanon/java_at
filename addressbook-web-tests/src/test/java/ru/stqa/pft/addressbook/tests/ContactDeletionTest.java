package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactDeletionTest extends TestBase {

   @Test
   public void testContactDeletion() {
      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         try { Thread.sleep(2000);
         }
         catch (InterruptedException ex) {
         }

         app.getContactHelper().createContact(new ContactData("Petr", "PetrovvvvVV1111111", "Ch111e", "+777777777777", "ya@ya.ru"));
      }
      app.getContactHelper().selectContact();
      app.getContactHelper().deletedSelectContact();
      app.getContactHelper().clicAlert();
      app.getNavigationHelper().gotoHomePage();


   }
}
