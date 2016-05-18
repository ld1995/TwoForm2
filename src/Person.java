
public class Person
{
    private String fastName;
    private String lastName;
    private String secondName;

    public Person()
    {

    }
//=======================================================================

    public Person splitFio(String fio)
    {
        String fIOUser[] = fio.split("\\s+");
        if(fIOUser.length == 3) {
            if (fIOUser[0].matches("^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$")) {
                setFastName(fIOUser[0]);
            }
            if (fIOUser[1].matches("^[А-ЯЁ][а-яё]+$")) {
                setLastName(fIOUser[1]);
            }
            if (fIOUser[2].matches("^[А-ЯЁ][а-яё]+$")) {
                setSecondName(fIOUser[2]);
            }
        }
        Person person = new Person();
        return person;
    }

    public void recordingForm(Form form)
    {
        setFastName(form.getFast().getText());
        setLastName(form.getLast().getText());
        setSecondName(form.getSecond().getText());
    }

    public void transferForm(FIO fio)
    {
        if (hasThreeNames())
        {
            fio.setFio(getFastName()+" " + getLastName()+" " + getSecondName());
        }
        else if (hasTwoNames())
        {
            fio.setFio(getFastName() + " " + getLastName());
        }
    }

    public void transferFio(Form form)
    {
        form.setFast(getFastName());
        form.setLast(getLastName());
        form.setSecond(getSecondName());
    }

    private boolean hasThreeNames()
    {
        return getLastName().trim().matches("^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$") &&
                getFastName().trim().matches("^[А-ЯЁ][а-яё]+$") &&
                getSecondName().trim().matches("^[А-ЯЁ][а-яё]+$");
    }

    private boolean hasTwoNames()
    {
        return getLastName().trim().matches("^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$") &&
                getFastName().trim().matches("^[А-ЯЁ][а-яё]+$");
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

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFastName(String fastName)
    {
        this.fastName = fastName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
}