import java.util.Random;

public class Wheeled extends Vehicle {
    private Random random = new Random();

    // sets up name and generates random speed and fuel values between the given
    // range
    public Wheeled(int number) {
        this.setName("W" + number);
        int random1 = random.nextInt(6);
        int random2 = random.nextInt(11);
        this.setSpeed(random1 + 15);
        this.setFuel(random2 + 30);
    }

    public void setFactor(float roadType) {
        if (roadType == 0) {
            super.setFactor(1.0f);
        }
        if (roadType == 1) {
            super.setFactor(0.75f);
        }
        if (roadType == 2) {
            super.setFactor(0.75f);
        }
    }

    // sets the factor according to road type, updates position and fuel, and
    // displays movements of vehicle
    public void move(int roadType) {
        if (this.getFuel() == 0) {
            System.out.println(this.getName() + " ran out of fuel!");
            this.setFuel(-1);
        }
        if (this.getFuel() > 0) {
            String road = "";

            if (roadType == 0) {
                road = "asphalt";
            }
            if (roadType == 1) {
                road = "dirt";
            }
            if (roadType == 2) {
                road = "stone";
            }

            this.setPosition(this.getPosition() + (this.getSpeed() * this.getFactor()));

            System.out.println(
                    this.getName() + " moves from " + road + ", for " + this.getSpeed() + " * " + this.getFactor()
                            + " = "
                            + this.getSpeed() * this.getFactor() + " units");

            this.setFuel(this.getFuel() - 1);
        }

    }
}
