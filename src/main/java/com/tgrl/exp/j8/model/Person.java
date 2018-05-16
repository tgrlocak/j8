package com.tgrl.exp.j8.model;

import java.util.Collections;
import java.util.List;

public class Person {
  String firstName;
  String lastName;
  String gender;
  String sth;
  String sthElse;

  public Person() {}

  public Person(String firstName) {
    this.firstName = firstName;
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public static List<Person> getPersons() {
    final List<Person> persons = Collections.emptyList();

    persons.add(new Person("First"));
    persons.add(new Person("Second"));
    persons.add(new Person("Third"));

    return persons;
  }

  public boolean isMale() {
    return this.gender.equals(Gender.MALE);
  }

  public boolean isFemale() {
    return this.gender.equals(Gender.FEMALE);
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getSth() {
    return sth;
  }

  public void setSth(String sth) {
    this.sth = sth;
  }

  public String getSthElse() {
    return sthElse;
  }

  public void setSthElse(String sthElse) {
    this.sthElse = sthElse;
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
}
