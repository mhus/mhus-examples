package de.mhus.examples.vaadin2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.DataProvider;

// https://vaadin.com/components/vaadin-grid

public class PanelGrid extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public PanelGrid() {
        
        Grid<Person> grid = new Grid<>();
        PersonService personService = new PersonService();

        /*
         * This Data Provider doesn't load all items into the memory right away.
         * Grid will request only the data that should be shown in its current
         * view "window". The Data Provider will use callbacks to load only a
         * portion of the data.
         */
        CallbackDataProvider<Person, Void> provider = DataProvider
                .fromCallbacks(query -> personService
                                .fetch(query.getOffset(), query.getLimit()).stream(),
                        query -> personService.count());
        grid.setDataProvider(provider);

        grid.addColumn(Person::getFirstName).setHeader("First Name");
        grid.addColumn(Person::getLastName).setHeader("Last Name");
        grid.addColumn(Person::getAge).setHeader("Age");
        
        grid.setWidth("500px");
        grid.setHeight("500px");
        
        add(grid);
    }
    
    public static class PersonService {

        public List<Person> fetch(int offset, int limit) {
            System.out.println("Fetch " + offset + " " + limit);
            LinkedList<Person> out = new LinkedList<>();
            for (int i = offset; i < offset + limit; i++)
                out.add(new Person(i, "John" + i, "Doe" + i, i % 10 + 10, new Address("12345","Town"), "800-400-300-100"));
            return out;
        }

        public int count() {
            return 100000;
        }
        
    }
    
    public static class Person implements Cloneable {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private Address address;
        private String phoneNumber;
        private MaritalStatus maritalStatus;
        private LocalDate birthDate;
        private boolean isSubscriber;
        private String email;

        public Person() {

        }

        public Person(int id, String firstName, String lastName, int age,
                      Address address, String phoneNumber) {
            super();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public Person(int id, String firstName, String lastName, int age,
                      Address address, String phoneNumber,
                      MaritalStatus maritalStatus, LocalDate birthDate) {
            super();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.maritalStatus = maritalStatus;
            this.birthDate = birthDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public MaritalStatus getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public String getImage() {
            return "https://randomuser.me/api/portraits/men/" + getId()
                    + ".jpg";
        }

        public boolean isSubscriber() {
            return isSubscriber;
        }

        public void setSubscriber(boolean isSubscriber) {
            this.isSubscriber = isSubscriber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Person)) {
                return false;
            }
            Person other = (Person) obj;
            return id == other.id;
        }

        @Override
        public String toString() {
            return firstName;
        }

        @Override
        public Person clone() { //NOSONAR
            try {
                return (Person) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(
                        "The Person object could not be cloned.", e);
            }
        }
    }

    public static class Address {
        private String street;
        private int number;
        private String postalCode;
        private String city;

        public Address() {

        }

        public Address(String postalCode, String city) {
            this.postalCode = postalCode;
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return String.format("%s %s", postalCode, city);
        }

    }

    public enum MaritalStatus {
        MARRIED, SINGLE;
    }
    
}
