package State;

public class OffCoffeeMachineState extends ACoffeeMachineState {

    OffCoffeeMachineState(CoffeeMachineImpl coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    void init() {
        log.info("Coffee machine is on now.");
        coffeeMachine.changeState(new OnCoffeeMachineState(coffeeMachine));
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
