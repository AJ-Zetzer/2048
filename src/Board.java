import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Board extends JPanel implements KeyListener
{

    JButton[][] square = new JButton[4][4];

    Border emptyBorder = BorderFactory.createEmptyBorder();

    Icon[] iconPics = new ImageIcon[12];

    public static Board inst;

    Boolean movePos = true;


    public static Board getInst()
    {
        if (inst == null)
        {
            inst = new Board();
        }
        return inst;
    }
    public Board()
    {

        iconPics[0] = new ImageIcon("pixil-frame-0.png");
        iconPics[1] = new ImageIcon("pixil-frame-1.png");
        iconPics[2] = new ImageIcon("pixil-frame-2.png");
        iconPics[3] = new ImageIcon("pixil-frame-3.png");
        iconPics[4] = new ImageIcon("pixil-frame-4.png");
        iconPics[5] = new ImageIcon("pixil-frame-5.png");
        iconPics[6] = new ImageIcon("pixil-frame-6.png");
        iconPics[7] = new ImageIcon("pixil-frame-7.png");
        iconPics[8] = new ImageIcon("pixil-frame-8.png");
        iconPics[9] = new ImageIcon("pixil-frame-9.png");
        iconPics[10] = new ImageIcon("pixil-frame-10.png");
        iconPics[11] = new ImageIcon("pixil-frame-11.png");


        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        setLayout(new GridLayout(4, 4));

        Random rand = new Random();

        int rowOne = rand.nextInt(4);
        int colOne = rand.nextInt(4);
        int rowTwo = rand.nextInt(4);
        int colTwo = rand.nextInt(4);


        for (int i = 0; i < 4; i++)
        {
            for (int k = 0; k < 4; k++)
            {

                        int startNum = rand.nextInt(2);
                        if (rowOne == i && colOne == k)
                        {
                            if(startNum == 0){square[i][k] = new JButton(iconPics[1]); square[i][k].setName("2");}
                            else if(startNum == 1){square[i][k] = new JButton(iconPics[2]); square[i][k].setName("4");}
                            square[i][k].setPreferredSize(new Dimension(150, 150));
                            square[i][k].setBorder(emptyBorder);
                            square[i][k].addKeyListener(this);
                        }
                        else if (rowTwo == i && colTwo == k)
                        {
                            if(startNum == 0){square[i][k] = new JButton(iconPics[1]); square[i][k].setName("2");}
                            else if(startNum == 1){square[i][k] = new JButton(iconPics[2]); square[i][k].setName("4");}
                            square[i][k].setPreferredSize(new Dimension(150, 150));
                            square[i][k].setBorder(emptyBorder);
                            square[i][k].addKeyListener(this);
                        }
                        else
                        {
                            square[i][k] = new JButton(iconPics[0]);
                            square[i][k].setPreferredSize(new Dimension(150, 150));
                            square[i][k].setBorder(emptyBorder);
                            square[i][k].setName("0");
                            square[i][k].addKeyListener(this);
                        }

                add(square[i][k]);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }


    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyChar() == 'd'){moveEast(); addSquare();}
        if(e.getKeyChar() == 'a'){moveWest(); addSquare();}
        if(e.getKeyChar() == 's'){moveSouth(); addSquare();}
        if(e.getKeyChar() == 'w'){moveNorth(); addSquare();}
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public void moveEast()
    {
        int count = 0;
        int last = count;
        int canMove = 0;
        do {
            last = count;
            for (int i = 0; i < 4; i++) {
                for (int k = 2; k >= 0; k--) {
                    if (!square[i][k].getName().equals("0")) {

                        String name = square[i][k].getName();
                        if (square[i][k + 1].getName().equals("0")) {
                            square[i][k + 1].setIcon(square[i][k].getIcon());
                            square[i][k + 1].setName(name);
                            square[i][k].setIcon(iconPics[0]);
                            square[i][k].setName("0");
                            count++;
                            repaint();
                        }
                        else if (square[i][k + 1].getName() == square[i][k].getName())
                        {
                            count++;

                            if (square[i][k].getName().equals("1024"))
                            {
                                square[i][k + 1].setIcon(iconPics[11]);
                                square[i][k + 1].setName("2048");
                            }
                            if (square[i][k + 1].getName().equals("512"))
                            {
                                square[i][k + 1].setIcon(iconPics[10]);
                                square[i][k + 1].setName("1024");
                            }
                            if (square[i][k + 1].getName().equals("256"))
                            {
                                square[i][k + 1].setIcon(iconPics[9]);
                                square[i][k + 1].setName("512");
                            }
                            if (square[i][k + 1].getName().equals("128"))
                            {
                                square[i][k + 1].setIcon(iconPics[8]);
                                square[i][k + 1].setName("256");
                            }
                            if (square[i][k + 1].getName().equals("64"))
                            {
                                square[i][k + 1].setIcon(iconPics[7]);
                                square[i][k + 1].setName("128");
                            }
                            if (square[i][k + 1].getName().equals("32"))
                            {
                                square[i][k + 1].setIcon(iconPics[6]);
                                square[i][k + 1].setName("64");
                            }
                            if (square[i][k + 1].getName().equals("16"))
                            {
                                square[i][k + 1].setIcon(iconPics[5]);
                                square[i][k + 1].setName("32");
                            }
                            if (square[i][k + 1].getName().equals("8"))
                            {
                                square[i][k + 1].setIcon(iconPics[4]);
                                square[i][k + 1].setName("16");
                            }
                            if (square[i][k + 1].getName().equals("4"))
                            {
                                square[i][k + 1].setIcon(iconPics[3]);
                                square[i][k + 1].setName("8");
                            }
                            if (square[i][k + 1].getName().equals("2"))
                            {
                                square[i][k + 1].setIcon(iconPics[2]);
                                square[i][k + 1].setName("4");
                            }
                            square[i][k].setName("0");
                            square[i][k].setIcon(iconPics[0]);
                            repaint();
                        }
                    }
                }
            }
            canMove++;
        }while(last != count);
        if(canMove == 1){movePos = false;}
    }

    public void moveWest()
    {
        int count = 0;
        int last = count;
        int canMove = 0;
        do {
            last = count;
            for (int i = 0; i < 4; i++) {
                for (int k = 1; k < 4; k++) {
                    if (!square[i][k].getName().equals("0")) {

                        if (square[i][k - 1].getName().equals("0")) {
                            count++;
                            square[i][k - 1].setIcon(square[i][k].getIcon());
                            square[i][k - 1].setName(square[i][k].getName());
                            square[i][k].setIcon(iconPics[0]);
                            square[i][k].setName("0");
                            repaint();
                        }
                        else if (square[i][k - 1].getName() == square[i][k].getName())
                        {
                            count++;

                            if (square[i][k].getName().equals("1024"))
                            {
                                square[i][k - 1].setIcon(iconPics[11]);
                                square[i][k - 1].setName("2048");
                            }
                            if (square[i][k - 1].getName().equals("512"))
                            {
                                square[i][k - 1].setIcon(iconPics[10]);
                                square[i][k - 1].setName("1024");
                            }
                            if (square[i][k - 1].getName().equals("256"))
                            {
                                square[i][k - 1].setIcon(iconPics[9]);
                                square[i][k - 1].setName("512");
                            }
                            if (square[i][k - 1].getName().equals("128"))
                            {
                                square[i][k - 1].setIcon(iconPics[8]);
                                square[i][k - 1].setName("256");
                            }
                            if (square[i][k - 1].getName().equals("64"))
                            {
                                square[i][k - 1].setIcon(iconPics[7]);
                                square[i][k - 1].setName("128");
                            }
                            if (square[i][k - 1].getName().equals("32"))
                            {
                                square[i][k - 1].setIcon(iconPics[6]);
                                square[i][k - 1].setName("64");
                            }
                            if (square[i][k - 1].getName().equals("16"))
                            {
                                square[i][k - 1].setIcon(iconPics[5]);
                                square[i][k - 1].setName("32");
                            }
                            if (square[i][k - 1].getName().equals("8"))
                            {
                                square[i][k - 1].setIcon(iconPics[4]);
                                square[i][k - 1].setName("16");
                            }
                            if (square[i][k - 1].getName().equals("4"))
                            {
                                square[i][k - 1].setIcon(iconPics[3]);
                                square[i][k - 1].setName("8");
                            }
                            if (square[i][k - 1].getName().equals("2"))
                            {
                                square[i][k - 1].setIcon(iconPics[2]);
                                square[i][k - 1].setName("4");
                            }
                            square[i][k].setName("0");
                            square[i][k].setIcon(iconPics[0]);
                            repaint();
                        }
                    }
                }
            }
            canMove++;
        }while(last != count);
        if(canMove == 1){movePos = false;}
    }

    public void moveNorth()
    {
        int count = 0;
        int last = count;
        int canMove = 0;
        do {
            last = count;
            for (int i = 0; i < 4; i++) {
                for (int k = 1; k < 4; k++) {
                    if (!square[k][i].getName().equals("0")) {

                        if (square[k - 1][i].getName().equals("0"))
                        {
                            count++;
                            square[k - 1][i].setIcon(square[k][i].getIcon());
                            square[k - 1][i].setName(square[k][i].getName());
                            square[k][i].setIcon(iconPics[0]);
                            square[k][i].setName("0");
                            repaint();
                        } else if (square[k - 1][i].getName() == square[k][i].getName())
                        {
                            count++;

                            if (square[k - 1][i].getName().equals("1024"))
                            {
                                square[k - 1][i].setIcon(iconPics[11]);
                                square[k - 1][i].setName("2048");
                            }
                            if (square[k - 1][i].getName().equals("512"))
                            {
                                square[k - 1][i].setIcon(iconPics[10]);
                                square[k - 1][i].setName("1024");
                            }
                            if (square[k - 1][i].getName().equals("256"))
                            {
                                square[k - 1][i].setIcon(iconPics[9]);
                                square[k - 1][i].setName("512");
                            }
                            if (square[k - 1][i].getName().equals("128"))
                            {
                                square[k - 1][i].setIcon(iconPics[8]);
                                square[k - 1][i].setName("256");
                            }
                            if (square[k - 1][i].getName().equals("64"))
                            {
                                square[k - 1][i].setIcon(iconPics[7]);
                                square[k - 1][i].setName("128");
                            }
                            if (square[k - 1][i].getName().equals("32"))
                            {
                                square[k - 1][i].setIcon(iconPics[6]);
                                square[k - 1][i].setName("64");
                            }
                            if (square[k - 1][i].getName().equals("16"))
                            {
                                square[k - 1][i].setIcon(iconPics[5]);
                                square[k - 1][i].setName("32");
                            }
                            if (square[k - 1][i].getName().equals("8"))
                            {
                                square[k - 1][i].setIcon(iconPics[4]);
                                square[k - 1][i].setName("16");
                            }
                            if (square[k - 1][i].getName().equals("4"))
                            {
                                square[k - 1][i].setIcon(iconPics[3]);
                                square[k - 1][i].setName("8");
                            }
                            if (square[k - 1][i].getName().equals("2"))
                            {
                                square[k - 1][i].setIcon(iconPics[2]);
                                square[k - 1][i].setName("4");
                            }
                            square[k][i].setName("0");
                            square[k][i].setIcon(iconPics[0]);
                            repaint();
                        }
                    }
                }
            }
            canMove++;
        }while(last != count);
        if(canMove == 1){movePos = false;}
    }

    public void moveSouth()
    {
        int count = 0;
        int last = count;
        int canMove = 0;
        do {
            last = count;
            for (int i = 0; i < 4; i++) {
                for (int k = 2; k >= 0; k--) {
                    if (!square[k][i].getName().equals("0")) {

                        if (square[k + 1][i].getName().equals("0")) {
                            count++;
                            square[k + 1][i].setIcon(square[k][i].getIcon());
                            square[k + 1][i].setName(square[k][i].getName());
                            square[k][i].setIcon(iconPics[0]);
                            square[k][i].setName("0");
                            repaint();
                        } else if (square[k + 1][i].getName() == square[k][i].getName()) {
                            count++;

                            if (square[k + 1][i].getName().equals("1024"))
                            {
                                square[k + 1][i].setIcon(iconPics[11]);
                                square[k + 1][i].setName("2048");
                            }
                            if (square[k + 1][i].getName().equals("512"))
                            {
                                square[k + 1][i].setIcon(iconPics[10]);
                                square[k + 1][i].setName("1024");
                            }
                            if (square[k + 1][i].getName().equals("256"))
                            {
                                square[k + 1][i].setIcon(iconPics[9]);
                                square[k + 1][i].setName("512");
                            }
                            if (square[k + 1][i].getName().equals("128"))
                            {
                                square[k + 1][i].setIcon(iconPics[8]);
                                square[k + 1][i].setName("256");
                            }
                            if (square[k + 1][i].getName().equals("64"))
                            {
                                square[k + 1][i].setIcon(iconPics[7]);
                                square[k + 1][i].setName("128");
                            }
                            if (square[k + 1][i].getName().equals("32"))
                            {
                                square[k + 1][i].setIcon(iconPics[6]);
                                square[k + 1][i].setName("64");
                            }
                            if (square[k + 1][i].getName().equals("16"))
                            {
                                square[k + 1][i].setIcon(iconPics[5]);
                                square[k + 1][i].setName("32");
                            }
                            if (square[k + 1][i].getName().equals("8"))
                            {
                                square[k + 1][i].setIcon(iconPics[4]);
                                square[k + 1][i].setName("16");
                            }
                            if (square[k + 1][i].getName().equals("4"))
                            {
                                square[k + 1][i].setIcon(iconPics[3]);
                                square[k + 1][i].setName("8");
                            }
                            if (square[k + 1][i].getName().equals("2"))
                            {
                                square[k + 1][i].setIcon(iconPics[2]);
                                square[k + 1][i].setName("4");
                            }
                            square[k][i].setName("0");
                            square[k][i].setIcon(iconPics[0]);
                            repaint();
                        }
                    }
                }
            }
            canMove++;
        }while(count != last);
        if(canMove == 1){movePos = false;}
    }

    public void addSquare()
    {
        if (movePos == true)
        {
            Random rand = new Random();
            int tileType = rand.nextInt(0, 1);
            int rowCord = rand.nextInt(0, 4);
            int colCord = rand.nextInt(0, 4);

            while (!square[rowCord][colCord].getName().equals("0")) {
                rowCord = rand.nextInt(0, 4);
                colCord = rand.nextInt(0, 4);

            }
            if (tileType == 0) {
                square[rowCord][colCord].setName("2");
                square[rowCord][colCord].setIcon(iconPics[1]);
            }
            if (tileType == 1) {
                square[rowCord][colCord].setName("4");
                square[rowCord][colCord].setIcon(iconPics[2]);
            }
        }
        movePos = true;
        didLose();
    }
    public void Clear()
    {
      for (int i = 0; i < 4; i++)
      {
          for (int k = 0; k < 4; k++)
          {
            square[k][i].setName("0");
            square[k][i].setIcon(iconPics[0]);
          }
      }
    }

    public void didLose()
    {
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int k = 0; k < 4; k++)
            {
                if (square[k][i].getName().equals("0")){count++;}
            }
            // check tiles around middle 6 tiles to see if compete to fix end of game bug.
        }
        if(count == 0){Clear(); addSquare(); addSquare();}
    }

}





