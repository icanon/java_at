package ru.stqa.pft.addressbook.generators;


import ru.stqa.pft.addressbook.model.GroupData;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

   public static void main(String[] args){
      int count = Integer.parseInt(args[0]);
      File file = new File(args[1]);

      List<GroupData> groups = generateGroups(count);
      save(groups, file);
   }

   private static List<GroupData> generateGroups(int count){
      List<GroupData> groups = new ArrayList<GroupData>();
      for (int i = 0; i < count; i++) {
         groups.add(new GroupData().withName(String.format("test %s", i))
         .withHeader(String.format("header %s", i))
         .withFooter(String.format("footer %s", i)));
      }
      return groups;
   }
}
