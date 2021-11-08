package machine;
import java.util.Scanner;

enum State {
    CHOOSING_AN_ACTION, CHOOSING_A_VARIANT_OF_COFFEE, FILLING_UP, EXECUTING_WITHDRAWAL, CHECKING_REMAINS, OFF
}

public class CoffeeMachine {
  static int waterIn = 400;
  static int milkIn = 540;
  static int coffeeIn = 120;
  static int cupsIn = 9;
  static int moneyIn = 550;
  static Cup espresso = new Cup(250,16,4);
  static Cup latte =  new Cup(350,75,20,7);
  static Cup cappuccino = new Cup(200,100,12,6);

    public static void main(String[] args) {
        State status = State.CHOOSING_AN_ACTION;

        while (status != State.OFF) {
           status = machineExecution(status);
       }
    }

    public static State machineExecution(State state) {
        Scanner scanner = new Scanner(System.in);
        switch (state) {
            case CHOOSING_AN_ACTION:
                switch (scanner.nextLine()) {
                    case "buy":
                        return State.CHOOSING_A_VARIANT_OF_COFFEE;
                    case "fill":
                        return State.FILLING_UP;
                    case "take":
                        return State.EXECUTING_WITHDRAWAL;
                    case "remaining":
                        return State.CHECKING_REMAINS;
                    case "exit":
                        return State.OFF;
                }
            case CHOOSING_A_VARIANT_OF_COFFEE:
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                if (cupsIn == 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else {
                    switch (scanner.nextLine()){
                        case "1":
                            if (waterIn < espresso.water) {
                                System.out.println("Sorry, not enough water!\n");
                            }
                            else if (coffeeIn < espresso.coffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!\n");
                            }
                            else {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                waterIn -= espresso.water;
                                coffeeIn -= espresso.coffeeBeans;
                                cupsIn -= 1;
                                moneyIn += espresso.price;
                            }
                            break;
                        case "2":
                            if (waterIn < latte.water) {
                                System.out.println("Sorry, not enough water!\n");
                            }
                            else if (milkIn < latte.milk) {
                                System.out.println("Sorry, not enough milk!\n");
                            }
                            else if (coffeeIn < latte.coffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!\n");
                            }
                            else {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                waterIn -= latte.water;
                                milkIn -= latte.milk;
                                coffeeIn -= latte.coffeeBeans;
                                cupsIn -= 1;
                                moneyIn += latte.price;
                            }
                            break;
                        case "3":
                            if (waterIn < cappuccino.water) {
                                System.out.println("Sorry, not enough water!\n");
                            }
                            else if (milkIn < cappuccino.milk) {
                                System.out.println("Sorry, not enough milk!\n");
                            }
                            else if (coffeeIn < cappuccino.coffeeBeans) {
                                System.out.println("Sorry, not enough coffee beans!\n");
                            } else {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                waterIn -= cappuccino.water;
                                milkIn -= cappuccino.milk;
                                coffeeIn -= cappuccino.coffeeBeans;
                                cupsIn -= 1;
                                moneyIn += cappuccino.price;
                            }
                            break;
                        case "back":
                            return State.CHOOSING_AN_ACTION;
                    }
                    return State.CHOOSING_AN_ACTION;
                }
            case FILLING_UP:
                System.out.println("\nWrite how many ml of water you want to add: ");
                waterIn += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add: ");
                milkIn += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add: ");
                coffeeIn += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                cupsIn += Integer.parseInt(scanner.nextLine());
                System.out.println();
                return State.CHOOSING_AN_ACTION;
            case EXECUTING_WITHDRAWAL:
                System.out.println("\nI gave you $" + moneyIn + "\n");
                moneyIn = 0;
                return State.CHOOSING_AN_ACTION;
            case CHECKING_REMAINS:
                System.out.println("\nThe coffee machine has:\n" +
                        waterIn + " ml of water\n" +
                        milkIn + " ml of milk\n" +
                        coffeeIn + " g of coffee beans\n" +
                        cupsIn + " disposable cups\n" +
                        "$" + moneyIn + " of money\n");
                return State.CHOOSING_AN_ACTION;
            default:
                return State.CHOOSING_AN_ACTION;
        }
    }

}
