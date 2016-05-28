package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactModificationTest extends TestBase {



   @BeforeMethod
   public void ensurePrecondisions() {
      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactHelper().isThereAContact()) {
         app.getContactHelper().
                 createContact(new ContactData(null, "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
   }


   @Test()
   public void testContactModification() {

      List<ContactData> before = app.getContactHelper().getContactList();
      int index = before.size();
      ContactData contact = new ContactData(before.get(before.size() - 1).
              getId(), "f222", "l2222", "22222", "+799999999999", "222222@2222.ru");
      app.getContactHelper().modifyContact(index, contact);
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(contact);

      Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }


}
