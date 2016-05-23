import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame
{
    private Form form = new Form();
    private FIO fio = new FIO();
    private Person person = new Person();

    public MyFrame() throws Exception
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setTitle("Fio");
        setContentPane(form.getRootPanel());
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        form.getComeOnButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switching();
            }
        });

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
                        KeyEvent.CTRL_DOWN_MASK),"left");
        getRootPane().getActionMap().put("left", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                switching();
            }
        });

        fio.getComeOnButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switching();
            }
        });
    }

    private boolean firstForm(Person person)
    {
        if (person.hasntControlFastAndLast())
        {
            JOptionPane.showMessageDialog(form.getRootPanel(),
                    "Заполните поля фамилии и имени!",
                    "Фамилия и имя",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (person.hasntControlSecond())
        {
            int option = JOptionPane.showConfirmDialog(form.getRootPanel(),
                    "Уверены ли Вы в том, что не хотите установить отчество?",
                    "Отчество",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.NO_OPTION)
            {
                form.getSecond().requestFocusInWindow();
                return false;
            }
            else
                return true;
        }
        else
            return true;
    }

    private void switching()
    {
        Person getPersonForm = form.getPerson();
        Person getPersonFio = fio.getPerson();

        if (getContentPane() == form.getRootPanel())
        {
            if (firstForm(getPersonForm))
            {
                fio.setPerson(getPersonForm);
                setContentPane(fio.getPanelFIO());
            }
        }
        else
        {
            if (person.hasСontrolFio(getPersonFio))
            {
                form.setPerson(getPersonFio);
                setContentPane(form.getRootPanel());
            }
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}