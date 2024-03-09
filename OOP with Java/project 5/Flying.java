import java.util.Random;

public class Flying extends Vehicle {
    private Random random = new Random();

    // sets up name and generates random speed and fuel values between the given
    // range
    public Flying(int number) {
        this.setName("F" + number);
        int random1 = random.nextInt(11);
        int random2 = random.nextInt(11);
        this.setSpeed(random1 + 20);
        this.setFuel(random2 + 20);
    }

    public void setFactor(float roadType) {
        super.setFactor(1.0f);
    }

    // updates position and fuel, and displays movements of vehicle
    public void move(int roadType) {
        if (this.getFuel() == 0) {
            System.out.println(this.getName() + " ran out of fuel!");
            this.setFuel(-1);
        }
        if (this.getFuel() > 0) {
            float factor = 1f;
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

            this.setPosition(this.getPosition() + (this.getSpeed() * factor));

            System.out.println(
                    this.getName() + " moves from " + road + ", for " + this.getSpeed() + " * " + factor + " = "
                            + this.getSpeed() * factor + " units");
            this.setFuel(this.getFuel() - 1);
        }

    }

}
