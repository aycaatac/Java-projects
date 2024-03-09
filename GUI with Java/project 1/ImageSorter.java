import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ImageSorter extends JFrame {
    static BufferedImage img;
    static JLabel label;
    static Timer timer;
    static int row = 0;
    static int column = 0;
    static ImageSorter x = new ImageSorter();
    ActionListener listener;
    KeyListener kListener;
    static int delayy = 100;
    int i = 0;
    int k = 0;
    boolean h_over = false;
    boolean v_over = false;

    // loading the image from the file to a bufferedimage
    public void loadImage(String fileName) {
        File file = new File(fileName);
        try {
            img = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // setting key controls/ 'r' for restart, '+' for speeding up, '-' for speeding
    // down
    class Keyboardlistener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'r') {
                row = 0;
                column = 0;
                delayy = 100;
                loadImage("original.jpg");
                displayImage();
                startAnimatedBubbleSort();
            }
            if (e.getKeyChar() == '+') {

                if (delayy - 100 >= 0) {
                    delayy -= 100;
                    timer.setDelay(delayy);
                }
            }
            if (e.getKeyChar() == '-') {
                delayy += 100;
                timer.setDelay(delayy);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

    // displays the image on a label on the frame
    public void displayImage() {
        label.setIcon(new ImageIcon(img));
        kListener = new Keyboardlistener();
        this.add(label, BorderLayout.CENTER);
        this.addKeyListener(kListener);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        x.loadImage("original.jpg");
        label = new JLabel(new ImageIcon(img), JLabel.CENTER);
        x.displayImage();
        x.startAnimatedBubbleSort();
    }

    // calls the diagonal step when it gets alerted by the timer
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            x.diagonalStep();
        }
    }

    // calls horizontal and vertical steps and displays the label
    public void diagonalStep() {
        x.horizontalStep();

        x.verticalStep();

        label.repaint();
        if (row >= img.getHeight() && column >= img.getWidth()) {
            timer.stop();
        }
    }

    // sets the listener and timers
    public void startAnimatedBubbleSort() {
        listener = new Listener();
        timer = new Timer(delayy, listener);
        timer.start();
    }

    // used to find brightness
    public static double findBrightness(int x, int y) {
        Color color = new Color(img.getRGB(x, y));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    }

    // sorts the pixels vertically
    public void verticalStep() {
        for (int p = 0; p < img.getHeight() && column < img.getWidth(); p++) {
            for (int j = 0; j < img.getHeight() - 1; j++) {
                if (findBrightness(column, j) < findBrightness(column, j + 1)) {
                    int temp = img.getRGB(column, j);
                    img.setRGB(column, j, img.getRGB(column, j + 1));
                    img.setRGB(column, j + 1, temp);
                }
            }
            ImageSorter.column++;
        }

        if (column >= img.getWidth()) {
            column = 0;
        }
    }

    // sorts the pixels horizontally
    public void horizontalStep() {

        for (int y = 0; y < img.getWidth() && row < img.getHeight(); y++) {
            for (int j = 0; j < img.getWidth() - 1; j++) {
                if (findBrightness(j, row) < findBrightness(j + 1, row)) {
                    int temp = img.getRGB(j + 1, row);
                    img.setRGB(j + 1, row, img.getRGB(j, row));
                    img.setRGB(j, row, temp);
                }
            }
            ImageSorter.row++;
        }

        if (row >= img.getHeight()) {
            row = 0;
        }

        label.repaint();

    }

}