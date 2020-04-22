package State;

public class DeliveredCoffeeMachineState extends ACoffeeMachineState {

    DeliveredCoffeeMachineState(CoffeeMachineImpl coffeeMachine) {
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
        //stub
    }

    @Override
    void deliverCoffee() {
        log.info("Coffee is ready.");
        coffeeMachine.changeState(new OnCoffeeMachineState(coffeeMachine));
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
