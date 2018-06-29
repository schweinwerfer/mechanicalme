package de.ora.mechanicalme;

import java.awt.*;
import java.util.Random;

public class StartMe {
    private Robot robot;
    private Point last;
    private Random rnd;

    public StartMe() throws AWTException, InterruptedException {
        rnd = new Random();
        robot = new Robot();
        while (true) {
            waitMillis(120000);
            Point current = MouseInfo.getPointerInfo().getLocation();
            if (last != null && last.equals(current)) {
                moveMouse();
            } else {
                last = current;
            }
        }
    }

    private void waitMillis(int i) throws InterruptedException {
        synchronized (robot) {
            robot.wait(i);
        }
    }

    public static void main(String[] input) throws AWTException, InterruptedException {
        StartMe startMe = new StartMe();

    }

    public void moveMouse() throws AWTException, InterruptedException {
        Point currentLocation = MouseInfo.getPointerInfo().getLocation();
        int diffX = rnd.nextInt(10);
        int diffY = rnd.nextInt(10);
        robot.mouseMove(currentLocation.x + diffX, currentLocation.y + diffY);
        waitMillis(500);
        diffX = rnd.nextInt(10);
        diffY = rnd.nextInt(10);
        robot.mouseMove(currentLocation.x + diffX, currentLocation.y + diffY);
        waitMillis(500);
        robot.mouseMove(currentLocation.x, currentLocation.y);
    }
}
