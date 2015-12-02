package org.pascalot.restService;

import org.pascalot.restResource.People;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hamisu on 12/1/15.
 */
@Component
public class PeopleService
{
    private final Map<String, People> peolpleMap = new ConcurrentHashMap<String, People>();

    public String createPeople(String firstName, String lastName, String dateOfBirth)
    {
        if(firstName!=null && !firstName.isEmpty() && lastName!=null && !lastName.isEmpty())
        {
            Instant doB = null;
            try{
               doB = Instant.parse(dateOfBirth);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            People p = new People(firstName, lastName, doB);
            peolpleMap.put(p.getFirstName()+p.getLastName(), p);
            return p.toString();
        }
        else{
            return MessageFormat.format("ERROR: Cannot create person with first name {0}, last name {1} and dateOfBirth {2}", firstName, lastName, dateOfBirth);
        }
    }

    public String getPeople(String firstName, String lastName, String dateOfBirth){
        if(peolpleMap.containsKey(firstName+lastName))
            return peolpleMap.get(firstName + lastName).toString();
            else{
            createPeople(firstName,lastName,dateOfBirth);
            return MessageFormat.format("ERROR: Cannot find person with first name {0}, last name {1} and dateOfBirth {2}", firstName, lastName, dateOfBirth);
        }
    }

    public String updatePeople(String firstName, String lastName, String dateOfBirth){
        if(peolpleMap.containsKey(firstName+lastName))
            return peolpleMap.get(firstName + lastName).toString();
        else{
            createPeople(firstName,lastName,dateOfBirth);
            return MessageFormat.format("ERROR: Cannot find person with first name {0}, last name {1} and dateOfBirth {2}", firstName, lastName, dateOfBirth);
        }
    }

    public String deletePeople(String firstName, String lastName, String dateOfBirth)
    {
        if (peolpleMap.containsKey(firstName + lastName))
            return MessageFormat.format("Deleted {0} from cache", peolpleMap.remove(firstName + lastName).toString());
        else
            return MessageFormat.format("ERROR: Cannot find person with first name {0}, last name {1} and dateOfBirth {2} on file", firstName, lastName, dateOfBirth);
    }

}
