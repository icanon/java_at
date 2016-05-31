package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePrecondisions() {

      app.goTo().groupPage();
      if (app.group().all().size() == 0){
         app.group().create(new GroupData().withName("test1"));
      }
   }


   @Test
   public void testGroupModification() {


      Groups before = app.group().all();
      GroupData modifyGroup = before.iterator().next();
      GroupData group = new GroupData().withId(modifyGroup.getId())
              .withName("testGGGG222")
              .withHeader("testGGGG2")
              .withFooter("testGGGGG3");
      app.group().modify(group);
      Groups after = app.group().all();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));

   }



}
