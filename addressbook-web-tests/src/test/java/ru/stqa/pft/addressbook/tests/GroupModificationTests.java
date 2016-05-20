package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by i.sokolov on 10.05.2016.
 */
public class GroupModificationTests extends TestBase {

   @Test
   public void testGroupModification() {

      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()){
         app.getGroupHelper().createGroup(new GroupData("testG1111", "testG2", null));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testGGGG222", "testGGGG2", "testGGGGG3"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
   }


}
