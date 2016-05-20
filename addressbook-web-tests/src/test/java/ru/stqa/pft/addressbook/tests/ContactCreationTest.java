package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {

      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("1111", "111111", "111111", "+777777777777", "111@111.ru"));
      app.getNavigationHelper().gotoHomePage();

   }


}
