
/*This class creates the game components and contains the main method
 * author@ Ayca Candan Atac
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private static JFrame frame;
    static int panelNo = 1;
    private int[] buttonColors;
    private static ActionListener listener;
    static int playerScore = 10;
    private GameButton[] buttonsInPanel;
    private static String answer = "b";
    static boolean playAgain = false;

    public int getPlayerScore() {
        return playerScore;
    }

    // creates the panels and buttons with recursion
    public GamePanel(int depth) {
        listener = new ButtonListener();
        buttonsInPanel = new GameButton[4];
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(Color.gray);
        if (depth > 0) {
            for (int i = 0; i < 4; i++) {
                this.add(new GamePanel(depth - 1));
                this.setLayout(new GridLayout(2, 2));
            }
        }
        if (depth == 0) {
            buttonColors = new int[4];
            GameButton b = new GameButton();
            for (int i = 0; i < 4; i++) {
                b = new GameButton();
                this.add(b);
                b.addActionListener(listener);
                b.setP(this);
                buttonColors[i] = b.getColorNo();
                buttonsInPanel[i] = b;
            }
            // checks if the game is already over or not
            b.grayChecker();
        }
    }

    public GameButton[] getButtonsInPanel() {
        return buttonsInPanel;
    }

    public int[] getButtonColors() {
        return buttonColors;
    }

    class ButtonListener implements ActionListener {

        // changes the button color, updates the color in array, checks the completed
        // panels, sets the player score and checks whether the game is over or not
        public void actionPerformed(ActionEvent e) {
            GameButton b = (GameButton) e.getSource();
            b.randomColor();
            b.updateArray();
            b.grayChecker();
            playerScore--;
            frame.setTitle("Player score: " + playerScore);
            overHandler();
        }
    }

    // checks whether the game is over or not
    public static void overHandler() {
        if (panelNo <= 0) {
            answer = JOptionPane.showInputDialog("You won! Do you want to play again?");
        }
        if (playerScore <= 0) {
            answer = JOptionPane.showInputDialog("You lost! Do you want to play again?");
        }
        while (!((answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("no"))
                || answer.toLowerCase().equals("b"))) {
            answer = JOptionPane.showInputDialog("Please enter yes or no! Do you want to play again?");
        }
        if (answer.toLowerCase().equals("yes")) {
            playAgain = true;
        }
    }

    // creates the frame, panels and buttons
    public static void game() {
        playerScore = 10;
        int depthQ = Integer.parseInt(JOptionPane.showInputDialog("Please enter the depth: "));
        panelNo = (int) Math.pow(4, depthQ);
        frame = new JFrame();
        frame.setSize(700, 700);
        GamePanel p = new GamePanel(depthQ);
        frame.add(p, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        overHandler();
        frame.setTitle("Player score: " + playerScore);
    }

    public static void main(String[] args) {
        // loop keeps going until player does not want to play
        do {
            playAgain = false;
            answer = "b";
            game();
            while (true) {
                if (playAgain) {
                    break;
                }
                if (answer.toLowerCase().equals("no")) {
                    System.exit(0);
                    break;
                }
            }
        } while (playAgain);
    }
}
