package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


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

      assertThat(Arrays.asList(contact.getAllPhones(), contact.getAllEmail(), contact.getAddress()),
              containsInAnyOrder(equalTo(mergePhones(contactInfoFromEditForm)),
                      equalTo(mergeEmail(contactInfoFromEditForm)), equalTo(contactInfoFromEditForm.getAddress())));

      // assertThat(contact.getAllEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
      // assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
   }



   @Test
   public void testViewPage() {

      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);

      assertThat(mergeEmail(contactInfoFromEditForm),equalTo(mergeEmail(contactInfoFromViewForm)));
      assertThat(mergeFrstAndLastName(contactInfoFromEditForm),equalTo(contactInfoFromViewForm.getFirstName()));
      assertThat(mergePhones(contactInfoFromEditForm),equalTo(mergePhones(contactInfoFromViewForm)));

   }



   private String mergeEmail(ContactData contact) {
      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
              .stream().filter((s) -> ! s.equals(""))
              .map(ContactPhoneTests::cleaned)
              .collect(Collectors.joining("\n"));
   }

   private String mergePhones(ContactData contact) {
      return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
             .stream().filter((s) -> ! s.equals(""))
             .map(ContactPhoneTests::cleaned)
              .collect(Collectors.joining("\n"));
   }

   private String mergeFrstAndLastName(ContactData contact) {
      return Arrays.asList(contact.getFirstName(), contact.getLastName())
              .stream().filter((s) -> ! s.equals(""))
              .map(ContactPhoneTests::cleanedName)
              .collect(Collectors.joining(" "));
   }

   public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "").replaceAll("[:HWM]", "");
   }

   public static String cleanedName(String name) {
      return name.replaceAll("\\s", "");
   }

}
