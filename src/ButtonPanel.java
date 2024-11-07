import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonPanel extends JPanel implements MouseListener {

    private static ButtonPanel inst;
    public static ButtonPanel getInst()
    {
        if (inst == null)
        {
            inst = new ButtonPanel();
        }
        return inst;
    }
    private ButtonPanel()
    {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        setLayout(new FlowLayout(1));
        JButton play = new JButton("Start New");


        play.setName("Play");
        play.addMouseListener(this);
        add(play);

    }

    public void mouseExited(MouseEvent evt){}
    public void mouseEntered(MouseEvent evt){}
    public void mousePressed(MouseEvent evt)
    {
        if (evt.getComponent().getName().equals("Play")){Board.inst = null;}
    }
    public void mouseClicked(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt){}
}


