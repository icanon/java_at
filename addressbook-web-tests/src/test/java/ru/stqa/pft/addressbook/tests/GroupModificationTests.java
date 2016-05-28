package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;


public class GroupModificationTests extends TestBase {

   @Test
   public void testGroupModification() {

      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()){
         app.getGroupHelper().createGroup(new GroupData("cG1111", "cG2222", null));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      int index = before.size() - 1;
      GroupData group = new GroupData(before.get(index).getId(), "testGGGG222", "testGGGG2", "testGGGGG3");

      app.getGroupHelper().selectGroup(index);
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(group);

      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
   }


}
