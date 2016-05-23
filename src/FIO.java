import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class FIO
{
    private JPanel rootPanel;
    private JButton comeOnButton;
    private JTextField Fio;
    private JProgressBar progressBar;

    public FIO()
    {
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(30);
        Fio.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void changedUpdate(DocumentEvent documentEvent)
            {
             print(documentEvent);
            }
            public void insertUpdate(DocumentEvent documentEvent) {
                print(documentEvent);
            }
            public void removeUpdate(DocumentEvent documentEvent) {
                print(documentEvent);
            }
            private void print(DocumentEvent documentEvent) {
                Document source = documentEvent.getDocument();
                int length = source.getLength();
                progressBar.setValue(length);
            }
        });
    }

    //===========================================================

    public JButton getComeOnButton() {
        return comeOnButton;
    }

    public JPanel getPanelFIO()
    {
        return rootPanel;
    }

    public JTextField getFio() {
        return Fio;
    }

    protected void setFio(String fio)  {
        this.Fio.setText(fio);
    }

    public void setPerson(Person person)
    {
        setFio(person.getFastName().trim() + " "
                + person.getLastName().trim() + " "
                + person.getSecondName().trim());
    }

    public Person getPerson()
    {
        String fast = "";
        String last = "";
        String second = "";
        String fIOUser[] = getFio().getText().trim().split("\\s+");
        if(fIOUser.length == 3)
        {
            fast = fIOUser[0];
            last = fIOUser[1];
            second = fIOUser[2];
        }
        Person person = new Person(fast,last,second);
        return person;
    }
}
