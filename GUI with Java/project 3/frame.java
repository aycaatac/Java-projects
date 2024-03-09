import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;    
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;                                  
         
import javax.swing.JButton;
import javax.swing.JFrame;            
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class frame extends JFrame {
    int FRAME_WIDTH = 700;
    int FRAME_HEIGHT = 500;
    bus c;
    JLabel widthlabel;
    JLabel wheelNolabel;
    JPanel inputPanel;
    JTextField forWidth;
    JTextField forWheel;
    JButton update;
    JPanel updatePanel;
    JButton play;
    JButton stop;
    JPanel playpanel;
    Timer t;
    boolean playing = false;

    public void createComponents() {
        // play and stop buttons
        play = new JButton("Play");
        stop = new JButton("Stop");
        playpanel = new JPanel();
        playpanel.setLayout(new GridLayout(0, 1));
        playpanel.setBounds(FRAME_WIDTH - 140, 20, 100, 50);
        playpanel.add(play);
        playpanel.add(stop);
        // update button
        update = new JButton("Update");
        updatePanel = new JPanel();
        updatePanel.setBounds(15, 65, 100, 50);
        updatePanel.add(update);
        // bus object
        c = new bus();
        c.setFrameWidth(FRAME_WIDTH);
        c.setFrameHeightt(FRAME_HEIGHT);
        c.findRadius(c.getBusWidth(), 5);
        c.setBounds(0, 60, FRAME_WIDTH, FRAME_HEIGHT - 60);
        // textfields
        forWidth = new JTextField(15);
        forWidth.setText("" + c.getBusWidth());
        forWheel = new JTextField(15);
        forWheel.setText("" + c.getWheelNo());
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBounds(15, 20, 100, 40);
        widthlabel = new JLabel("Length: ");
        wheelNolabel = new JLabel("Wheel: ");
        inputPanel.add(widthlabel);
        inputPanel.add(forWidth);
        inputPanel.add(wheelNolabel);
        inputPanel.add(forWheel);
        // listener and timer
        ActionListener listener = new Listener();
        play.addActionListener(listener);
        stop.addActionListener(listener);
        update.addActionListener(listener);
        t = new Timer(100, listener);
        t.start();
        // adding components to the frame
        this.add(c);
        this.add(inputPanel);
        this.add(updatePanel);
        this.add(playpanel);
        this.setLayout(null);
        this.setTitle("Animated School Bus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        frame n = new frame();
        n.createComponents();
    }

    // implementing the update, play and stop buttons
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(update)) {
                c.setCoord(40, 70);
                c.setBusWidth(Integer.parseInt(forWidth.getText()));
                c.setWheelNo(Integer.parseInt(forWheel.getText()));
                c.repaint();
            }
            if (e.getSource().equals(stop)) {
                playing = false;
            }
            if (e.getSource().equals(play)) {
                playing = true;
            }
            if (playing) {
                // making the bus move
                c.animating();
            }
        }
    }
}
