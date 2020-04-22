package State;

public class CoffeeMachineImpl implements ICoffeeMachine {

    protected final static int COFFEE_PRICE = 40;

    protected int wallet;

    ACoffeeMachineState aCoffeeMachineState = new OffCoffeeMachineState(this);

    @Override
    public void deposit(int moneyAmount) {
        wallet += moneyAmount;
    }

    @Override
    public void prepareCoffee() {
        aCoffeeMachineState.prepareCoffee();
    }

    @Override
    public void deliverCoffee() {
        aCoffeeMachineState.deliverCoffee();
    }

    @Override
    public void giveChange(int moneyAmount) {
        if (wallet != 0) {
            aCoffeeMachineState.giveChange(wallet);
        }
    }

    @Override
    public void dispatchError() {
        //stub
    }

    @Override
    public void init() {
        aCoffeeMachineState.init();
    }

    @Override
    public void stop() {
        aCoffeeMachineState.stop();
    }

    public void changeState(ACoffeeMachineState aCoffeeMachineState) {
        this.aCoffeeMachineState = aCoffeeMachineState;
    }
}

