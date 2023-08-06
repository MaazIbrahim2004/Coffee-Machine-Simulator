import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    
    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) { 
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean runningProgram = true;
        CoffeeMachine coffeeMachine = new CoffeeMachine(water, milk, coffeeBeans, cups, money); 

        while (runningProgram) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("buy");
                    coffeeMachine.buy(scanner); //passing scanner object to buy method as parameter
                    break;
                case "fill":
                    System.out.println("fill");
                    coffeeMachine.fill(scanner);
                    break;
                case "take":
                    System.out.println("take");
                    coffeeMachine.take();
                    break;
                case "remaining":
                    System.out.println("remaining");
                    coffeeMachine.printMachineState();
                    break;
                case "exit":
                    System.out.println("exit");
                    runningProgram = false;
                    break;
            }
        }
    }


    public void buy(Scanner scanner) { // we pass scanner object as parameter to avoid creating multiple scanner objects

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = scanner.nextLine();
        switch (buy) {
            case "1":
                if (water >= 250 && coffeeBeans >= 16 && cups >= 1) { 
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    cups -= 1;
                    money += 4; 
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups -= 1;
                    money += 7;
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups -= 1;
                    money += 6;
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "back":
                break;
        }
    }

    public void fill(Scanner scanner) {

        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        water += addWater;
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        milk += addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffeeBeans = scanner.nextInt();
        coffeeBeans += addCoffeeBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();
        cups += addCups;
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void printMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
