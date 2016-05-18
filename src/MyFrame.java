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
                firstForm();
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
                if(getContentPane()==form.getRootPanel())
                {
                    firstForm();
                }
                else
                {
                    switchingFio();
                }
            }
        });

        fio.getComeOnButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchingFio();
            }
        });
    }

    private void firstForm()
    {
        if (form.getFast().getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(form.getRootPanel(),
                    "Заполните поле Фамилии",
                    "Фамилия",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if (form.getLast().getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(form.getRootPanel(),
                    "Заполните поле Имени",
                    "Имя",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if (form.getSecond().getText().trim().equals(""))
        {
            int option = JOptionPane.showConfirmDialog(form.getRootPanel(),
                    "Уверены ли Вы в том, что не хотите установить отчество",
                    "Отчество",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION)
            {
                switchingForm();
            }
            else
            {
                form.getSecond().requestFocusInWindow();
            }
        }
        else
        {
            switchingForm();
        }
    }

    private void switchingForm()
    {
        person.recordingForm(form);
        person.transferForm(fio);
        fio.setProgressBar(fio.getProgressBar().getMaximum());
        setContentPane(fio.getPanelFIO());
        switching();
    }

    public void switchingFio()
    {
        person.splitFio(fio.getFio().getText());
        person.transferFio(form);
        setContentPane(form.getRootPanel());
        switching();
    }

    public void switching()
    {
        validate();
        repaint();
    }
}