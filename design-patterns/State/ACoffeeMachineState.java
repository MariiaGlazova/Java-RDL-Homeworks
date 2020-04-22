package State;

import java.util.logging.Logger;

public abstract class ACoffeeMachineState {

    protected static Logger log = Logger.getLogger(OffCoffeeMachineState.class.getName());

    CoffeeMachineImpl coffeeMachine;

    ACoffeeMachineState(CoffeeMachineImpl coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    abstract void init();

    abstract void stop();

    abstract void prepareCoffee();

    abstract void deliverCoffee();

    abstract void giveChange(int moneyAmount);

    abstract void dispatchError();
}

