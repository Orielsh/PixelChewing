import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PicturePanel extends JPanel {

    private Picture picture;
    private final int squareSize = 30;
    private final int gap = 3;
    private int panelEdge = 0;
    PicturePanel(Picture p) {
        super();
        picture = p;
        int n = p.getSize();
        panelEdge = (gap+squareSize)*n + gap;
        this.setPreferredSize(new Dimension(panelEdge,panelEdge));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(new MListener());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = this.picture.getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
        for(int i = 0; i< size ; i++){
            for (int j = 0; j< size ; j++){
                if (picture.getPixel(i,j).isAlive()){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(gap + (squareSize+gap)*i, gap + (squareSize+gap)*j, squareSize, squareSize);
            }
        }
    }

    private class MListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            if(x < panelEdge - gap && y < panelEdge - gap){
                int line = Math.floorDiv(x,squareSize + gap);
                int row = Math.floorDiv(y, squareSize + gap);
                picture.getPixel(line,row).flip();
                repaint();
            }
        }
    }
}
