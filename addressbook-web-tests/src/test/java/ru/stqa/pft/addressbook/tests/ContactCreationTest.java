package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TastBase {


   @Test
   public void testContactCreation() {

      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().fillContactForm(new ContactData("Ivan", "Ivanov", "Che", "+798765432109", "ya@ya.ru"));
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().gotoHomePage();
   }

}
