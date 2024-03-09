
/**This program uses the Vehicle class and it's subclasses and generates a race.
 *  author@ Ayca Candan Atac
 */
import java.util.Random;
import java.util.Scanner;

public class Simulation {
    static int[] roadType;
    static int[] roadLength;
    private static Random random = new Random();
    private static Vehicle[] vehicles;
    private static int endPosition = 0;
    static int turnNo;
    static boolean isOver = false;
    static Scanner scanner = new Scanner(System.in);

    public static void displayRoad(int totalLength) {
        turnNo = 0;
        isOver = false;
        int k = totalLength / 5;
        int random_Parts = random.nextInt(2, k + 1);
        roadType = new int[random_Parts];
        roadLength = new int[random_Parts];
        endPosition = totalLength;

        // generating a random road
        int random3;
        for (int i = 0; i < random_Parts; i++) {
            int random1 = random.nextInt(3);
            if (i == random_Parts - 1) {
                random3 = k;
            } else {
                random3 = random.nextInt(1, k - (random_Parts - i - 2));
            }
            roadType[i] = random1;
            roadLength[i] = random3 * 5;
            k -= random3;
        }

        // displaying the road
        System.out.println("The following road is generated: ");

        for (int i = 0; i < roadType.length; i++) {
            if (i == 0) {
                System.out.print("|");
            }
            if (roadType[i] == 0) {
                System.out.print("-Asphalt " + roadLength[i]);
            } else if (roadType[i] == 1) {
                System.out.print("-Dirt " + roadLength[i]);
            } else if (roadType[i] == 2) {
                System.out.print("-Stone " + roadLength[i]);
            }
            System.out.print("-|");
        }
        System.out.println("\n");
    }

    // generates and displays vehicles created by the number of vehicles taken from
    // the user
    public static void displayVehicles(int noOfVehicles) {
        vehicles = new Vehicle[noOfVehicles];
        int Wno = 0;
        int Fno = 0;
        int Qno = 0;
        int current = 0;

        // creating vehicles
        while (current < noOfVehicles) {
            int random4 = random.nextInt(20);
            if (random4 >= 0 && random4 < 5) {
                vehicles[current] = new Flying(Fno + 1);
                Fno++;
                current++;
            } else if (random4 >= 5 && random4 < 12) {
                vehicles[current] = new Quadruped(Qno + 1);
                Qno++;
                current++;
            } else if (random4 >= 12 && random4 < 20) {
                vehicles[current] = new Wheeled(Wno + 1);
                Wno++;
                current++;
            }
        }
        // displaying vehicles
        System.out.println("The following vehicles are generated: ");

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].toStr();
        }

    }

    // gets the road type according to a vehicle's current position
    public static int getType(float position) {
        int sum = 0;
        int index = 0;
        if (position == 0) {
            return roadType[0];
        }
        for (int k = 0; k < roadLength.length && position > sum; k++) {
            sum += roadLength[k];
            index = k;
        }
        if (position == sum && sum != 0) {
            return roadType[index + 1];
        }
        if (sum > position) {
            return roadType[index];
        }

        return -1;
    }

    // prints vehicles' status and movements, simulates the game
    public static void simulate() {
        System.out.print("Please enter the road length: ");
        int length = scanner.nextInt();
        System.out.println();
        displayRoad(length);
        System.out.print("Please enter vehicle count: ");
        int vehicleCount = scanner.nextInt();
        scanner.nextLine();
        displayVehicles(vehicleCount);
        do {
            for (int i = 0; i < vehicles.length; i++) {
                vehicles[i].setFactor(getType(vehicles[i].getPosition()));
            }
            turnNo++;
            System.out.println("\nTurn " + turnNo + ": ");
            for (int j = 0; j < vehicles.length; j++) {
                if (vehicles[j].getFuel() > 0) {
                    vehicles[j].toString();
                }
            }
            System.out.println("\nMovements: ");
            for (int j = 0; j < vehicles.length && !isOver(); j++) {
                if ((vehicles[j].getPosition() + (vehicles[j].getSpeed() * vehicles[j].getFactor()) >= endPosition)
                        && vehicles[j].getFuel() > 0) {
                    vehicles[j].move(getType(vehicles[j].getPosition()));
                    System.out.println(
                            "\n" + vehicles[j].getName() + " finishes the race! Position: " + vehicles[j].getPosition()
                                    + " - Speed: "
                                    + vehicles[j].getSpeed() + " - Fuel: " + vehicles[j].getFuel());
                    System.out.println();
                    isOver = true;
                } else {
                    vehicles[j].move(getType(vehicles[j].getPosition()));
                }
            }
        } while (!isOver());
    }

    // checks if there is a winner or if all vehicles have 0 fuel
    public static boolean isOver() {
        if (isOver) {
            return true;
        }
        boolean fuelEnd = true;
        for (Vehicle v : vehicles) {
            if (!(v.getFuel() <= 0)) {
                fuelEnd = false;
            }
        }
        if (fuelEnd) {
            System.out.println("There are no winners. All of the vehicles are out of fuel.\n");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String answer = "yes";

        // loop for stimulating the race
        while (answer.equals("yes")) {
            simulate();
            System.out.print("End of stimulation. Do you want to play again? ");
            answer = scanner.nextLine();
        }

        scanner.close();
    }

}
