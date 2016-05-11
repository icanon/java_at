package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {

      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().fillContactForm(new ContactData("Ivan222222222222", "IvanovVV1111111", "Ch111e", "+798765432109", "ya@ya.ru"));
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().gotoHomePage();

   }



}
