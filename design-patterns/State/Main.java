package State;

public class Main {

    public static void main(String[] args) {
        ICoffeeMachine iCoffeeMachine = new CoffeeMachineImpl();
        iCoffeeMachine.init();
        iCoffeeMachine.deposit(50);
        iCoffeeMachine.prepareCoffee();
        iCoffeeMachine.giveChange(1);
        iCoffeeMachine.stop();
        iCoffeeMachine.init();
        iCoffeeMachine.giveChange(1);
    }
}
