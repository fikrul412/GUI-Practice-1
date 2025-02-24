import javax.swing.*;

public class WindowFrame extends JFrame {
    public WindowFrame (){
        this.setSize(400,400);
        this.setTitle("GUI Practice");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    public void exec_(){
        DrawPanel panel = new DrawPanel();
        this.add(panel);
        panel.startLoop();
        this.setVisible(true);
    }
}
