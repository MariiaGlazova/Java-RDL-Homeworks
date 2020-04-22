package State;

public class PreparingCoffeeMachineState extends ACoffeeMachineState {

    PreparingCoffeeMachineState(CoffeeMachineImpl coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    void init() {
        //stub
    }

    @Override
    void stop() {
        //stub
    }

    @Override
    void prepareCoffee() {
        log.info("Coffee is being prepared.");
        coffeeMachine.changeState(new DeliveredCoffeeMachineState(coffeeMachine));
        coffeeMachine.deliverCoffee();
    }

    @Override
    void deliverCoffee() {
        //stub
    }

    @Override
    void giveChange(int moneyAmount) {
        //stub
    }

    @Override
    void dispatchError() {
        //stub
    }
}