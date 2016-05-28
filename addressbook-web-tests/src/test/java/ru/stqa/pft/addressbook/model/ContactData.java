package ru.stqa.pft.addressbook.model;

public class ContactData {

   private int id;
   private final String firstName;
   private final String lastName;
   private final String address;
   private final String mobile;
   private final String email;


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
      return !(lastName != null ? !lastName.equals(that.lastName) : that.lastName != null);

   }

   @Override
   public int hashCode() {
      int result = firstName != null ? firstName.hashCode() : 0;
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      return result;
   }

   public ContactData(String firstName, String lastName, String address, String mobile, String email) {
      this.id = Integer.MAX_VALUE;
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.mobile = mobile;
      this.email = email;

   }

   @Override
   public String toString() {
      return "ContactData{" +
              "id='" + id + '\'' +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }

   public ContactData(int id, String firstName, String lastName, String address, String mobile, String email) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.mobile = mobile;
      this.email = email;
   }


   public void setId(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getAddress() {
      return address;
   }

   public String getMobile() {
      return mobile;
   }

   public String getEmail() {
      return email;
   }

}
