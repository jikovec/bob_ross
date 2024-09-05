import java.util.Scanner;

/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 *      HitDetection is a program that checks whether the user provided point by its X and Y coordinates hits
 *      any of the user provided circles by their X and Y coordinates. Then the program returns an appropriate message with the information
 *      about the hit.
 * 
 * @author Anton Cipel
 * @ID 2128748
 * @author Jakub Bojnanský
 * @ID 2145243
 * 
 */

class HitDetection {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        double[] inputs = readDoubleInputs(scanner, "Enter all values: ");

        double xCircle1 = inputs[0];
        double yCircle1 = inputs[1];
        double rCircle1 = inputs[2];
        double xCircle2 = inputs[3];
        double yCircle2 = inputs[4];
        double rCircle2 = inputs[5];
        double guessX = inputs[6];
        double guessY = inputs[7];

        // negative radius
        if (rCircle1 < 0 || rCircle2 < 0) {
            System.out.println("input error");
            return;
        }

        scanner.close();

        double distance1 = Math.pow((guessX - xCircle1), 2) + Math.pow((guessY - yCircle1), 2);
        double distance2 = Math.pow((guessX - xCircle2), 2) + Math.pow((guessY - yCircle2), 2);

        if (distance1 <= Math.pow(rCircle1, 2) && distance2 <= Math.pow(rCircle2, 2)) {
            System.out.println("The point hits both circles");
            return;
        }
        if (distance1 <= Math.pow(rCircle1, 2)) {
            System.out.println("The point hits the first circle");
        } else if (distance2 <= Math.pow(rCircle2, 2)) {
            System.out.println("The point hits the second circle");
        } else {
            System.out.println("The point does not hit either circle");
        }
    }

    public static double[] readDoubleInputs(Scanner scan, String prompt) {
        double[] inputs = new double[8];
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String line = scan.nextLine().strip();
            String[] tokens = line.split(" ");
            try {
                if (tokens.length != 8) {
                throw new Error("input error");
            }
                for (int i = 0; i < 8; i++) {
                    inputs[i] = Double.parseDouble(tokens[i]);
                }
                valid = true;
            } catch (Error e) {
                System.out.println("input error");
                System.exit(0);
            }
        }
        return inputs;
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}
