package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
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
         app.getContactHelper().createContact(new ContactData("11111", "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().selectContact();
      app.getContactHelper().deletedSelectContact();
      app.getContactHelper().clicAlert();
      app.getNavigationHelper().gotoHomePage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before - 1);
   }
}
