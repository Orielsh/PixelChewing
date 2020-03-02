import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonsPanel extends JPanel {

        private JButton go = new JButton("GO!");
        private JButton clear = new JButton("Clear");
        private Picture picture;
        private JPanel panel;
        private int m_threadNumbers = 0;
        private int m_transitions = 0;
        private int currentPhaze = 0;
        private int currentRunning = 0;
        private boolean started = false;
        int row = 0;
        int col = 0;

    ButtonsPanel(Picture p, JPanel panel, int n, int t){
        super();
        m_transitions = t;
        m_threadNumbers = n;
        this.picture = p;
        this.panel = panel;
        this.add(go);
        this.add(Box.createRigidArea(new Dimension(50,0)));
        this.add(clear);

        Listener listener = new Listener();
        go.addActionListener(listener);
        clear.addActionListener(listener);

    }

    public class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if ( e.getSource() == clear){
                picture.clear();
                panel.repaint();
            }
            if ( e.getSource() == go){
                run();
            }
        }
    }

    private void run(){
        Thread[] thread = new Thread[m_threadNumbers];
        currentRunning = m_threadNumbers;
        currentPhaze = row = col = 0;
        for (int j=0; j<m_threadNumbers; j++){
            thread [j] = new Thread(this::runInConcurrent);
            thread [j].start();
        }
    }

    private void runInConcurrent(){
        int r =0,c =0;
        while(currentPhaze < m_transitions){
            synchronized (picture){
                if(col == row && row == picture.getSize()-1) {
                    if(currentRunning == 1){
                        try {
                            synchronized (picture) {
                                Thread.sleep(800);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        picture.evolve();
                        panel.repaint();
                        row = 0;
                        col = 0;
                        picture.notifyAll();
                        currentPhaze++;
                    }else{
                        try {
                            currentRunning--;
                            picture.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        currentRunning++;
                    }
                }else{
                    if(col == picture.getSize()){
                        r = row ++;
                        c = col = 0;
                    }else{
                        r = row;
                        c = col++;
                    }
                }
            }
            picture.evolve(r,c);
        }
    }
}
