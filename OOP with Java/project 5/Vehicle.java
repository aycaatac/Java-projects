public class Vehicle {
    private String name;
    private float speed;
    private float position;
    private int fuel;
    private float factor;

    public Vehicle() {
        name = " ";
        speed = 0;
        position = 0;
        fuel = 0;
    }

    public String getName() {
        return name;
    }

    public float getSpeed() {
        return speed;
    }

    public float getPosition() {
        return position;
    }

    public int getFuel() {
        return fuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void move(int roadType) {
        if (fuel > 0) {
            position += speed;
            fuel--;
        }
    }

    // to display vehicle status at each round
    public String toString() {
        System.out.println(this.name + " - Position: " + this.position + " - Speed: " + (int) this.speed + " - Fuel: "
                + this.fuel);

        return "";
    }

    // to display vehicle when it is first created
    public void toStr() {
        System.out.println(this.name + " - Speed: " + (int) this.speed + " - Fuel: " + this.fuel);
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

}