import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;     
import javax.swing.JFrame;

public class bus extends JComponent {
    int x = 40;
    int y = 70;
    int busLength = 400;
    int busHeight = 110;
    int moveX = 10;
    int moveY = 3;
    int frontX = 50;
    int frontY = 50;
    int radius;
    int winWidth;
    int wheelSpace;
    int windowSpace;
    int wheelNo = 5;
    int windowY = y + 10;
    int windowNo = 4;
    int frameWidth;
    int frameHeightt;
    int real;

    // finding the radius of the wheels according to bus length and wheel numbers
    public void findRadius(int busl, int nowheel) {
        real = busl - frontX;
        wheelSpace = real / (2 * nowheel + nowheel + 1);
        radius = wheelSpace;
        windowSpace = real / (4 * windowNo + 1);
        winWidth = 3 * windowSpace;
        wheelSpace += 2;
    }

    // updating x coordinate to make the bus move
    public void animating() {
        x += moveX;
        if (x <= 0 || x + this.busLength >= frameWidth) {
            moveX = moveX * -1;
        }
        repaint();
    }

    public void setCoord(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setBusWidth(int busWidht) {
        this.busLength = busWidht;
    }

    public int getBusWidth() {
        return busLength;
    }

    public void setFrameWidth(int fw) {
        this.frameWidth = fw;
    }

    public void setFrameHeightt(int fh) {
        this.frameHeightt = fh;
    }

    // painting the floor, bus, windows and wheels
    public void paintComponent(Graphics g) {
        frontX = busLength / 7;
        frontY = busLength / 7;
        findRadius(busLength, wheelNo);
        g.setColor(new Color(120, 201, 120));
        g.fillRect(0, y + busHeight - frontY + 15, frameWidth, frameHeightt - (y + busHeight - frontY - 15));
        g.setColor(new Color(255, 190, 0));
        g.fillRect(x, y, busLength - frontX, busHeight);
        g.fillRect(x + busLength - frontX, y + busHeight - frontY, frontX, frontY);
        g.setColor(new Color(92, 44, 6));
        for (int i = 0; i < wheelNo; i++) {
            g.fillOval(x + i * 2 * radius + (i + 1) * wheelSpace, y + busHeight - radius, 2 * radius, 2 * radius);
        }
        g.setColor(new Color(215, 235, 253));

        for (int k = 0; k < windowNo; k++) {
            int winH = winWidth;
            if(winH > 60){
                winH = 50;
            }
            g.fillRect(x + k * winWidth + (k + 1) * windowSpace, windowY, winWidth, winH);
        }
    }

    public void setWheelNo(int wheelNo) {
        this.wheelNo = wheelNo;
    }

    public int getWheelNo() {
        return this.wheelNo;
    }

}
