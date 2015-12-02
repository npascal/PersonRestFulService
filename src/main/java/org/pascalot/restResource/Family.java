package org.pascalot.restResource;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hamisu on 12/1/15.
 */
public class Family implements Serializable
{
    private String lastName;
    private List<People> members;

    public Family()
    {}

    public Family(String lastName, List<People>members)
    {
        this.lastName = lastName;
        this.members = members;
    }
    public String getLastName()
    {
        return lastName;
    }

    public List<People> getMembers()
    {
        return members;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setMembers(List<People> members)
    {
        this.members = members;
    }

    @Override
    public String toString(){
        return "Family [lastName=" + lastName + ", members="
                + members + "]";
    }
}
