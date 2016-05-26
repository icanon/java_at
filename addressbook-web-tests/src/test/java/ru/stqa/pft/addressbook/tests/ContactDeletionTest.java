package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

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
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact();
      app.getContactHelper().deletedSelectContact();
      app.getContactHelper().clicAlert();
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);

      
   }
}
