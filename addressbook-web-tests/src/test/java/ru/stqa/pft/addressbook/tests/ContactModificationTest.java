package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Serj222222",
                "Serj222222", "Ch111eeee", "+799999999999", "yayayaya@ya.ru"));
        app.getContactHelper().updateContactModification();
        app.getNavigationHelper().gotoHomePage();

    }
}
