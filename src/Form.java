import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
       person.setFastName(getFast().getText());
       person.setLastName(getLast().getText());
       person.setSecondName(getSecond().getText());
    }

    public Person getPerson(Person person)
    {
        setFast(person.getFastName());
        setLast(person.getLastName());
        setSecond(person.getSecondName());
        return person;
    }
}
