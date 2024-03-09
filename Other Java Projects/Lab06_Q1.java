/**This program executes different functions like decoding a given password, finding the sum of a numbers prime factors, 
 * checking if given three numbers are a Pythagorean triplet, execute and and or on binary numbers.
 * @author Ayca Candan Atac
 */

import java.util.Scanner;

public class Lab06_Q1 {

    /**
     * This method decodes the given password according to the given function.
     * @param x- the password that is gonna be decoded
     * @return password- the decoded password
     */
    public static int passwordDecoder(int x) {
        String str = Integer.toString(x);
        int length = str.length();
        int password = 0;

        for (int i = 0; i < length; i++) {
            int digit = x % 10;
            digit = digitDecoder(digit);
            password += digit * Math.pow(10, i);
            x = x / 10;
        }

        return password;
    }

    /**
     * This method returns the largest integer less than or equal to the given number
     * @param j- the double number which is going to be floored
     * @return i - 1 - the largest integer less than or equal to the given number
     */
    public static int floor(double j) {
        boolean found = false;
        int i;
        for (i = 0; found == false; i++) {

            if (j > i && j < i + 1) {
                found = true;
                j = i;
            }

            if (j == i) {
                found = true;
                j = i;
            }
        }

        return i - 1;
    }

    /**
     * THis method decodes a digit using the given function
     * @param n- the digit which is going to be decoded
     * @return number- the decoded digit
     */
    public static int digitDecoder(int n) {
        int number = floor(10 - Math.pow(n / 2.0 - 3, 2) - 0.32);

        return number;
    }

    /**
     * This method checks if a number is a prime number or not
     * @param a- the number being checked
     * @return boolean true or false
     */
    public static boolean isPrime(int a) {
        int count = 0;
        for (int b = 1; b <= a; b++) {
            if (a % b == 0) {
                count++;
            }
        }
        return count == 2;
    }
    /**This method finds the sum of a given numbers prime factors
     * 
     * @param p- the given number
     * @return sum- the sum of the prime factors
     */
    public static int primeSummation(int p) {
        int sum = 0;
        for (int y = 1; y <= p; y++) {
            if (p % y == 0 && isPrime(y)) {
                sum += y;
            }
        }
        return sum;
    }
    /**
     * This method calculates the bth power of a
     * @param a- the number
     * @param b - the power
     * @return c - the result
     */
    public static int power(int a, int b) {
        int k;
        int c = 1;
        for (k = 1; k <= b; k++) {
            c = c * a;
        }

        return c;
    }
    /**
     * THis method checks if a given triple is a Pythagorean triple or not.
     * @param a- number 1
     * @param b- number 2
     * @param c- number 3
     * @return boolean- true or false
     */
    public static boolean isPythagorean(int a, int b, int c) {
        boolean isPythagorean;
        if (power(a, 2) == power(b, 2) + power(c, 2)) {
            isPythagorean = true;
            System.out.println(
                    "The triplet is Pythagorean, power(" + a + ",2) = power(" + b + ",2) + power(" + c + ",2)");
        } else if (power(b, 2) == power(a, 2) + power(c, 2)) {
            isPythagorean = true;
            System.out.println("The triplet is Pythagorean, power(" + b + ",2) = power(" + a + ",2) + power(" + c + ",2)");
        } else if (power(c, 2) == power(b, 2) + power(a, 2)) {
            isPythagorean = true;
            System.out.println("The triplet is Pythagorean, power(" + c +",2) = power(" + a + ",2) + power(" + b + ",2)");
        } else {
            isPythagorean = false;
            System.out.println("The triplet is not Pythagorean.");
        }
        return isPythagorean;
    }
    /**
     * THis methods turns a given number to binary
     * @param number- given number
     * @return sumForBİnary- binary number
     */
    public static long intToBinary(int number) {
        int i = 0;
        int newNumber = number;
        int sumForBinary = 0;

        if (number % 2 == 1) {
            sumForBinary = 1;
        } else {
            sumForBinary = 0;
        }

        while (newNumber > 1) {
            while (newNumber > 1) {
                newNumber = floor(newNumber / 2);
                i++;
            }
            sumForBinary = sumForBinary + power(10, i);
            newNumber = number - power(2, i);
            number = newNumber;
            i = 0;
        }
        return sumForBinary;
    }
    /**
     * THis method executes the AND operator on the binary number
     * @param no1
     * @param no2
     * @return sum- a binary number
     */
    public static long binaryAND(int no1, int no2) {
        long binary1 = intToBinary(no1);
        long binary2 = intToBinary(no2);
        int length = (int)Math.log10(binary1) + 1;
        long digit1;
        long digit2;
        long sum = 0;

        for (int r = 1; r <= length; r++) {
            digit1 = binary1 % 10;
            digit2 = binary2 % 10;
            if (digit1 == 1 && digit2 == 1) {
                sum += 1 * power(10, r - 1);
            }
            binary1 = (binary1 - digit1) / 10;
            binary2 = (binary2 - digit2) / 10;

        }
        return sum;
    }
    /**
     * This method executes the OR operator on the binary number
     * @param no3
     * @param no4
     * @return sum_ - a binary number
     */
    public static long binaryOR(int no3, int no4) {
        long binary3 = intToBinary(no3);
        long binary4 = intToBinary(no4);
        int digitNo = (int) Math.log10(binary3) + 1;
        long digit3;
        long digit4;
        long sum_ = 0;

        for (int i = 1; i <= digitNo; i++) {
            digit3 = binary3 % 10;
            digit4 = binary4 % 10;
            if (digit3 == 0 && digit4 == 0) {

            } else {
                sum_ += 1 * power(10, i - 1);
            }
            binary3 = (binary3 - digit3) / 10;
            binary4 = (binary4 - digit4) / 10;
        }
        return sum_;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //asking for inputs and printing the results
        System.out.print("Please input the password: ");
        int x = scanner.nextInt();
        x = passwordDecoder(x);
        System.out.println("The decoded password is: " + x);
        System.out.print("Please input the natural number: ");
        int no = scanner.nextInt();
        int result = primeSummation(no);
        System.out.println("The summation of the prime factors of " + no + " is " + result + ".");
        System.out.print("Please input the first number: ");
        int a = scanner.nextInt();
        System.out.print("Please input the second number: ");
        int b = scanner.nextInt();
        System.out.print("Please input the third number: ");
        int c = scanner.nextInt();
        isPythagorean(a, b, c);
        System.out.print("Please enter the first natural number: ");
        int no1 = scanner.nextInt();
        System.out.print("Please enter the second natural number: ");
        int no2 = scanner.nextInt();
        long binary1 = intToBinary(no1);
        long binary2 = intToBinary(no2);
        System.out.println("Binary representation of the first number: " + binary1);
        System.out.println("Binary representation of the second number: " + binary2);
        long binaryAND = binaryAND(no1, no2);
        System.out.println("The bitwise AND operation result: " + binaryAND);
        long binaryOr = binaryOR(no1, no2);
        System.out.println("The bitwise OR operation result: " + binaryOr);
       

        scanner.close();

    }

}