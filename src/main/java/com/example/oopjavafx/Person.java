package com.example.oopjavafx;

/**
 * The `Person` class represents a generic person with basic information such as first name, last name, nationality, gender, and age.
 * It is an abstract class, meaning it cannot be instantiated directly. Subclasses must be created to provide specific implementations.
 */
public abstract class Person {

    /**
     * The first name of the person.
     */
    public final String first_name;

    /**
     * The last name of the person.
     */
    public final String last_name;

    /**
     * The nationality of the person.
     */
    public final String nationality;

    /**
     * The gender of the person.
     */
    public final String gender;

    /**
     * The age of the person.
     */
    public int age;

    /**
     * Constructs a new instance of the `Person` class with the specified parameters.
     *
     * @param first_name  the first name of the person
     * @param last_name   the last name of the person
     * @param nationality the nationality of the person
     * @param gender      the gender of the person
     * @param age         the age of the person
     */
    public Person(String first_name, String last_name, String nationality, String gender, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nationality = nationality;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Retrieves the first name of the person.
     *
     * @return the first name of the person
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return the last name of the person
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Retrieves the nationality of the person.
     *
     * @return the nationality of the person
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Retrieves the age of the person.
     *
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the age to be set
     */
    public void setAge(int age) {
        this.age = age;
    }
}