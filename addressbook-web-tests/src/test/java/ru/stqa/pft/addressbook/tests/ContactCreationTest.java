package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> before = app.getContactHelper().getContactList();
      ContactData contact = new ContactData("1111", "111111", "111111", "+777777777777", "111@111.ru");
      app.getContactHelper().createContact(contact);
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);





   }


}
