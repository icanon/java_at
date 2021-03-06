package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {

   private int id = Integer.MAX_VALUE;

   private String firstName;
   private String lastName;
   private String group;
   private String homePhone;
   private String workPhone;
   private String allPhones;


   private String allEmail;
   private String address;
   private String mobile;
   private String email;
   private String email2;
   private String email3;
   private File photo;


   public ContactData withPhoto(File photo) {
      this.photo = photo;
      return this;
   }

   public ContactData withWorkPhone(String workPhone) {
      this.workPhone = workPhone;
      return this;
   }

   public ContactData withHomePhone(String homePhone) {
      this.homePhone = homePhone;
      return this;
   }

   public ContactData withId(int id) {
      this.id = id;
      return this;
   }


   public ContactData withAllEmail(String allEmail) {
      this.allEmail = allEmail;
      return this;
   }

   public ContactData withEmail1(String email) {
      this.email = email;
      return this;
   }


   public ContactData withEmail2(String email2) {
      this.email2 = email2;
      return this;
   }

   public ContactData withEmail3(String email3) {
      this.email3 = email3;
      return this;
   }

   public ContactData withGroup(String group) {
      this.group = group;
      return this;
   }

   public ContactData withAllPhones(String allPhones) {
      this.allPhones = allPhones;
      return this;
   }

   public ContactData withFirstName(String firstName) {

      this.firstName = firstName;
      return this;
   }

   public ContactData withLastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   public ContactData withAddress(String address) {
      this.address = address;
      return this;
   }

   public ContactData withMobile(String mobile) {
      this.mobile = mobile;
      return this;
   }



   public int getId() {
      return id;
   }

   public File getPhoto() {
      return photo;
   }

   public String getAllPhones() {
      return allPhones;
   }

   public String getAllEmail() {
      return allEmail;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getGroup() {
      return group;
   }


   public String getAddress() {
      return address;
   }

   public String getWorkPhone() {
      return workPhone;
   }


   public String getHomePhone() {
      return homePhone;
   }


   public String getMobile() {
      return mobile;
   }



   public String getEmail() {
      return email;
   }

   public String getEmail3() {
      return email3;
   }

   public String getEmail2() {
      return email2;
   }




   @Override
   public String toString() {
      return "ContactData{" +
              "id='" + id + '\'' +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (id != that.id) return false;
      if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
      return !(lastName != null ? !lastName.equals(that.lastName) : that.lastName != null);

   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      return result;
   }
}
