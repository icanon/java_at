package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TastBase {

   @Test
   public void testGroupDeletion() {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deletedSelectGroups();
      app.getGroupHelper().returnToGroupPage();
   }

}
