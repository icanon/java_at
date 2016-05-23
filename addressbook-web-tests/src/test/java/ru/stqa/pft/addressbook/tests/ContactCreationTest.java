package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {
      app.getNavigationHelper().gotoHomePage();
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().createContact(new ContactData("1111", "111111", "111111", "+777777777777", "111@111.ru"));
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getNavigationHelper().gotoHomePage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before + 1);
   }


}
