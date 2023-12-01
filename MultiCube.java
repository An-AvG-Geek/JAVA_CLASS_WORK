package java_lab;

import java.util.Random;

class NumManager {
    private int generatedNumber;
    private boolean numberGenerated = false;

    public synchronized void generateNumber() {
        generatedNumber = new Random().nextInt(99) + 2;
        System.out.println("Number is " + generatedNumber);
        numberGenerated = true;
        notifyAll(); 
    }

    public synchronized void Square() {
        try {
            while (!numberGenerated || generatedNumber % 2 != 0) {
                wait();
            }

            System.out.println("The number is even so its square is " + generatedNumber * generatedNumber);
            numberGenerated = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void Cube() {
        try {
            while (!numberGenerated || generatedNumber % 2 == 0) {
                wait();
            }
            System.out.println("The number is odd so its cube is " + generatedNumber * generatedNumber * generatedNumber);
            numberGenerated = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NumberGenerator extends Thread {
    private NumManager numManager;

    public NumberGenerator(NumManager numberManager) {
        this.numManager = numberManager;
        this.setName("NumberGenerator");
    }

    public void run() {
        while (true) {
            numManager.generateNumber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Even extends Thread {
    private NumManager numManager;

    public Even(NumManager numManager) {
        this.numManager = numManager;
        this.setName("Even");
    }

    public void run() {
        while (true) {
            numManager.Square();
        }
    }
}

class Odd extends Thread {
    private NumManager numManager;

    public Odd(NumManager numManager) {
        this.numManager = numManager;
        this.setName("Odd");
    }

    public void run() {
        while (true) {
            numManager.Cube();
        }
    }
}

public class MultiCube {
    public static void main(String[] args) {

        NumManager numberManager = new NumManager();

        NumberGenerator numberGenerator = new NumberGenerator(numberManager);
        Even even = new Even(numberManager);
        Odd odd = new Odd(numberManager);

        numberGenerator.start();
        even.start();
        odd.start();
    }
}
