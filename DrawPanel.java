import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawPanel extends JPanel implements Runnable{
    int w = 500;
    int h = 500;
    double i = 30;
    double dt = 0;
    Thread loop;
    double a;
    double x_random;

    public DrawPanel(){
        this.setPreferredSize(new Dimension(w,h));
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.circle(g2d);
    }
    private void circle(Graphics2D g){

        if (i>300 || i == 30 && dt ==0){
            i = 30;
            dt = 0;
            x_random = 10 +  Math.random() * 390;
            a = 0.1 + Math.random() * 2;
        }
        if (i < 300){
            dt += 1;
            i += 0.5*a*dt*dt;
        }
        g.setStroke(new BasicStroke(6));
        Ellipse2D.Double c = new Ellipse2D.Double(x_random,i, 10, 10);
        g.draw(c);
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
    public void startLoop(){
        loop = new Thread(this);
        loop.start();
    }
}