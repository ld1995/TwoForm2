
public class Person
{
    private String fastName;
    private String lastName;
    private String secondName;

    public Person()
    {

    }

    public Person(String fastName, String lastName, String secondName)
    {
        this.fastName = fastName;
        this.lastName = lastName;
        this.secondName = secondName;
    }
    //=======================================================================
    public boolean hasСontrolFio(Person person)
    {
        if (person.getFastName().trim().isEmpty() &&
                person.getLastName().trim().isEmpty() &&
                person.getSecondName().trim().isEmpty())
        {
            return false;
        }
        else
            return true;
    }

    public boolean hasntControlSecond()
    {
        if (!getSecondName().trim().isEmpty())
        {
            return false;
        }
        else
            return true;
    }

    public boolean hasntControlFastAndLast()
    {
        if (!getFastName().trim().isEmpty() && !getLastName().trim().isEmpty())
        {
            return false;
        }
        else
            return true;
    }
    //=======================================================================

    public String getLastName()
    {
        return lastName;
    }

    public String getFastName()
    {
        return fastName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    protected void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    protected void setFastName(String fastName)
    {
        this.fastName = fastName;
    }

    protected void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
}