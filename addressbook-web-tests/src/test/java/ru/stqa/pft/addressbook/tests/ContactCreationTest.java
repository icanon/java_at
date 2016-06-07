package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      File photo = new File("src/test/resources/ph1.jpeg");
      ContactData contact = new ContactData()
              .withFirstName("111")
              .withLastName("last2")
              .withAddress("ул.Маршала жукова д64/2")
              .withEmail1("tyut@ya.ru")
              .withEmail2("jhj@34.ru")
              .withEmail3("56@h4.com")
              .withHomePhone("889-99")
              .withMobile("+765453234554")
              .withWorkPhone("55 55")
              .withPhoto(photo);
      app.contact().create(contact);

      assertEquals(app.contact().count(), before.size() + 1);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size() + 1);
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


   }



}
