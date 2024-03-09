
/*This class extends JButton class and contains a variable for the button color, and also has methods to check 
the panels for button colors
 * author@ Ayca Candan Atac
 */
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;

public class GameButton extends JButton {
    Random random = new Random();
    private int colorNo;// 0 for red 1 for blue 2 for green 3 for gray
    GamePanel p;
    int before;

    // gives the button a random color at constructor
    public GameButton() {
        this.randomColor();
    }

    // assigns a random color to the button
    public void randomColor() {
        before = this.colorNo;
        int randNo = random.nextInt(3);
        this.colorNo = randNo;
        if (colorNo == 0) {
            this.setBackground(Color.red);
        }
        if (colorNo == 1) {
            this.setBackground(Color.blue);
        }
        if (colorNo == 2) {
            this.setBackground(Color.green);
        }
        if (colorNo == 4) {
            this.setBackground(Color.gray);
        }
    }

    // checks whether all of the buttons in a panel are the same color or not
    public void grayChecker() {
        int[] colors = this.p.getButtonColors();
        boolean same = true;
        for (int i = 0; i + 1 < colors.length; i++) {
            if (colors[i] != colors[i + 1]) {
                same = false;
            }
        }
        if (same) {

            for (int k = 0; k < colors.length; k++) {
                this.p.getButtonsInPanel()[k].setBackground(Color.gray);
                this.p.getButtonsInPanel()[k].setEnabled(false);
            }
            GamePanel.playerScore += 10;
            GamePanel.panelNo--;

        }
    }

    // updates the array that stores the button colors in that panel
    public void updateArray() {
        int[] colors = this.p.getButtonColors();

        for (int y = 0; y < colors.length; y++) {
            if (colors[y] == before) {

                colors[y] = colorNo;
                break;
            }
        }
    }

    public int getColorNo() {
        return colorNo;
    }

    public void setP(GamePanel p) {
        this.p = p;
    }
}
