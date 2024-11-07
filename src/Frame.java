import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static Frame inst;
    public static Frame getInst()
    {
        if (inst == null)
        {
            inst = new Frame();
        }
        return inst;
    }
    Frame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 100);
        setSize(600, 650);

        ButtonPanel buttonPanel = ButtonPanel.getInst();
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        Board board = Board.getInst();
        getContentPane().add(board, BorderLayout.CENTER);
        validate();
        setVisible(true);

    }
    public static void main(String args[])
    {
        Frame.getInst();
        inst.setResizable(false);
    }
}
