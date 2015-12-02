package org.pascalot.restResource;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by hamisu on 12/1/15.
 */
public class Person implements Serializable
{
    private String firstName, lastName, gender;
    private Instant dateOfBirth;

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public Instant getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setDateOfBirth(Instant dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
                + dateOfBirth + "]";
    }
}
