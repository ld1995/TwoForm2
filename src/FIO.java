import com.sun.xml.internal.ws.api.server.DocumentAddressResolver;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class FIO
{
    private JPanel rootPanel;
    private JButton comeOnButton;
    private JTextField Fio;
    private JProgressBar progressBar;

    private int type = 3;

    public FIO()
    {
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        Fio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()== KeyEvent.VK_BACK_SPACE || e.getKeyCode()== KeyEvent.VK_DELETE)
                {
                    progressBar.setValue(progressBar.getValue()-type);
                    if(Fio.getText().equals(""))
                    {
                        progressBar.setValue(progressBar.getMinimum());
                    }
                }
                else if (e.getKeyCode()== KeyEvent.VK_V && e.isControlDown())
                {
                    progressBar.setValue(progressBar.getMaximum());
                }
                else if (e.getKeyCode()== KeyEvent.VK_X && e.isControlDown())
                {
                    progressBar.setValue(progressBar.getMinimum());
                }
                else if (e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode()== KeyEvent.VK_UP  ||
                        e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode()== KeyEvent.VK_RIGHT
                        || e.getKeyCode()== KeyEvent.VK_CONTROL )
                {
                }
                else
                {
                    progressBar.setValue(progressBar.getValue()+type);
                }
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

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(int i) {
        this.progressBar.setValue(i);
    }
}
