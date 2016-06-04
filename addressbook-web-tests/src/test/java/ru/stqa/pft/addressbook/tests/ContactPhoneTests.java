package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests  extends TestBase{


   @BeforeMethod
   public void ensurePrecondisions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData().withFirstName("11111111"));
      }
   }


   @Test
   public void testContactPhone() {

      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
   }



   private String mergePhones(ContactData contact) {
      return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
             .stream().filter((s) -> ! s.equals(""))
             .map(ContactPhoneTests::cleaned)
              .collect(Collectors.joining("\n"));

   }

   public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
   }

}


//div[@id='content']/a[contains(@href,'mail')] находит email
//div[@id='content']/b                          находим имя и фамилию

//div[@id='content']/b/following-sibling::text()
//div[@id='content']/a[contains(@href,'mail')]/preceding-sibling::text()[not(contains[text(),')'])]
//div[@id='content']/a[contains(@href,'mail')]/following-sibling::text()[not(contains[text(),')'])] находим скобки и пробелы