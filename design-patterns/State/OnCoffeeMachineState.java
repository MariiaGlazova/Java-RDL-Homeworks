package State;

public class OnCoffeeMachineState extends ACoffeeMachineState {

    OnCoffeeMachineState(CoffeeMachineImpl coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    void init() {
        //stub
    }

    @Override
    void stop() {
        log.info("Coffee machine is off now.");
        coffeeMachine.changeState(new OffCoffeeMachineState(coffeeMachine));
    }

    @Override
    void prepareCoffee() {
        if (coffeeMachine.wallet >= CoffeeMachineImpl.COFFEE_PRICE) {

            coffeeMachine.wallet -= 40;

            log.info("The machine is preparing to make coffee.");

            coffeeMachine.changeState(new PreparingCoffeeMachineState(coffeeMachine));
            coffeeMachine.prepareCoffee();
        }

    }

    @Override
    void deliverCoffee() {
        //stub
    }

    @Override
    void giveChange(int moneyAmount) {
        coffeeMachine.wallet -= moneyAmount;
        log.info("Your change is " + moneyAmount + " coins");
    }

    @Override
    void dispatchError() {
        //stub
    }
}

