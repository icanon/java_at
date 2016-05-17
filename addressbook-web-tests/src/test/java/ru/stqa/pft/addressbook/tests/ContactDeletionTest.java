package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactDeletionTest extends TestBase {

   @Test
   public void testContactDeletion() {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deletedSelectContact();
      app.getContactHelper().clicAlert();
      app.getNavigationHelper().gotoHomePage();


   }
}
