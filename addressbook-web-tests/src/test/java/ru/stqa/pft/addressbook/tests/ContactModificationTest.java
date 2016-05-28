package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().createContact(new ContactData(null, "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().initContactModification(before.size());
      ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "f222", "l2222", "22222", "+799999999999", "222222@2222.ru");
      app.getContactHelper().fillContactForm(contact);
      app.getContactHelper().updateContactModification();
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());


      before.remove(before.size() - 1);
      before.add(contact);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


   }
}
