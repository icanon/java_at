package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


   @Test()
   public void testContactCreation() {
      app.goTo().homePage();
      List<ContactData> before = app.сontact().list();
      ContactData contact = new ContactData("1111", "111111", "111111", "+777777777777", "111@111.ru");
      app.сontact().create(contact);
      List<ContactData> after = app.сontact().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);

      Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);






   }


}
