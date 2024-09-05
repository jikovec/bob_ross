import java.util.Scanner;

/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * 
 * END TODO
 * 
 * @author Anton Cipel
 * @ID 2128748
 * @author Jakub Bojnanský
 * @ID 2145243
 * 
 */

class HitDetection {

    public void run() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        double xCircle1 = scanner.nextDouble();
        double yCircle1 = scanner.nextDouble();
        double rCircle1 = scanner.nextDouble();
        double xCircle2 = scanner.nextDouble();
        double yCircle2 = scanner.nextDouble();
        double rCircle2 = scanner.nextDouble();
        double guessX = scanner.nextDouble();
        double guessY = scanner.nextDouble();

        if (rCircle1 < 0 || rCircle2 < 0) {
            System.out.println("The radius of the circle must be a positive number");
            scanner.close();
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

    public static void main(String[] args) {
        new HitDetection().run();
    }
}
