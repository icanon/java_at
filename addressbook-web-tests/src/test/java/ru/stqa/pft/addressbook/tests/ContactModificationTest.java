package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactModificationTest extends TestBase {



   @BeforeMethod
   public void ensurePrecondisions() {
      app.goTo().homePage();
      if (app.сontact().list().size() == 0) {
         app.сontact().create(new ContactData(null, "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
   }


   @Test
   public void testContactModification() {

      List<ContactData> before = app.сontact().list();
      int index = before.size();
      ContactData contact = new ContactData(before.get(before.size() - 1).
              getId(), "f222", "l2222", null, null, null);
      app.сontact().modify(index, contact);
      
      List<ContactData> after = app.сontact().list();
      Assert.assertEquals(after.size(), before.size());
      before.remove(before.size() - 1);
      before.add(contact);
      Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }


}
