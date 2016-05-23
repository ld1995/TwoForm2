import javax.swing.*;

public class Form
{
    private JPanel rootPanel;
    private JTextField Fast;
    private JButton comeOnButton;
    private JTextField Last;
    private JTextField Second;

    //=======================================================================

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getSecond() {
        return Second;
    }

    public JTextField getLast() {
        return Last;
    }

    public JTextField getFast() {
        return Fast;
    }

    public JButton getComeOnButton() {
        return comeOnButton;
    }

    protected void setFast(String fast) {
       this.Fast.setText(fast);
    }

    protected void setLast(String last) {
        this.Last.setText(last);
    }

    protected void setSecond(String second) {
        this.Second.setText(second);
    }

    public void setPerson(Person person)
    {
       setFast(person.getFastName());
       setLast(person.getLastName());
       setSecond(person.getSecondName());
    }

    public Person getPerson()
    {
        Person person = new Person(getFast().getText(),getLast().getText(),getSecond().getText());
        return person;
    }
}
