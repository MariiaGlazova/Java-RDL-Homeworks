package Decorator;

public class BlueMatrioshkaDecorator extends MatrioshkaDecorator {

    public BlueMatrioshkaDecorator(AMatrioshka aMatrioshka) {
        super(aMatrioshka);
    }

    @Override
    public String getName() {
        return "Blue " + aMatrioshka.getName();
    }
}
