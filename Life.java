import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Transient;
import java.util.Random;



@SuppressWarnings("serial")
public class Life extends JPanel {
    
    private int[][] cells;
    private static final Random states = new Random();
 
    public static int count=0;

    public Life(int width, int height, String pattern) {
        this.cells = new int[width/7][height/7];
        if (pattern.equals("R")){
            cellsLayout();
        }
        else if(pattern.equals("G")){
            GliderLayout();
        }
        else{
            System.out.print("Incorrect pattern entry.");
        }
        
    }

    private void cellsLayout() {
        for (int[] row : cells) {
            for (int j = 0; j < row.length; j++) {
                
                row[j] = states.nextInt(2);

             }
         }
    }

    private void GliderLayout() {
        for (int i=0;i<cells.length;i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(j==14&&i==4||j==14&&i==10) cells[i][j]=1;
                if(j==15&&i==4||j==15&&i==10) cells[i][j]=1;
                if(j==26&&i==2||(j==26&&i==3)||(j==26&&i==7)||(j==26&&i==8))cells[i][j]=1;
                if((j==24&&i==3)||(j==24&&i==7))cells[i][j]=1;
                if(j==22&&i==4||j==22&&i==5||j==22&&i==6) cells[i][j]=1;
                if(j==23&&i==4||j==15&&i==5) cells[i][j]=1;
                if(j==36&&i==4||j==36&&i==5) cells[i][j]=1;
                if(j==37&&i==4||j==37&&i==5) cells[i][j]=1;
                if(j==13&&i==5||j==13&&i==9) cells[i][j]=1;
                if(j==17&&i==5||j==17&&i==9) cells[i][j]=1;
                if(j==2&&i==6||j==2&&i==7) cells[i][j]=1;
                if(j==3&&i==6||j==3&&i==7) cells[i][j]=1;
                if(j==12&&i==6||j==12&&i==7||j==12&&i==8) cells[i][j]=1;
                if(j==18&&i==7||j==18&&i==8) cells[i][j]=1;
                if(j==19&&i==7) cells[i][j]=1;

             }
         }
    }

    private void rules(int i, int j) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int upLeft = 0;
        int upRight = 0;
        int bLeft = 0;
        int bRight = 0;

        if (j < cells.length - 1) {
            right = cells[i][j + 1];
            if(i>0)
                upRight = cells[i - 1][j + 1];
            if (i < cells.length - 1)
                bRight = cells[i + 1][j + 1];
        }

        if (j > 0) {
            left = cells[i][j - 1];
            if (i > 0)
                upLeft = cells[i - 1][j - 1];
            if (i< cells.length-1)
                bLeft = cells[i + 1][j - 1];
        }

        if (i > 0)
            up = cells[i - 1][j];
        if (i < cells.length - 1)
            down = cells[i + 1][j];

        int total = left + right + up + down + upLeft + upRight
                + bLeft
                + bRight;

                if (cells[i][j] == 1) {
                    if (total < 2)
                        cells[i][j] = 0;
                    if (total > 3)
                        cells[i][j] = 0;
                }
        
                else {
                    if (total == 3)
                        cells[i][j] = 1;
                }


    }

    public void newcells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                rules(i, j);
             }
        }

    
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == 1) {
                    g.setColor(Color.black);
                    g.fillRect(j*7, i*7, 7, 7);
                }
            }
        }

        g.setColor(Color.BLACK);
    }

    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(cells.length*7, cells[0].length*7);
    }

    public static void main(String[] args) {
        int size= Integer.parseInt(args[0]);
        int numI= Integer.parseInt(args[1]);
        String pattern=args[2];
        
        Life grid = new Life(size*10, size*10, pattern);
        JFrame frame = new JFrame();
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        new Timer(60, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(count<numI){
                    grid.newcells();
                    grid.repaint();
                    count++;
                }
                
            }
        }).start();
    }
}