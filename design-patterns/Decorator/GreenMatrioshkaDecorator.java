package Decorator;

public class GreenMatrioshkaDecorator extends MatrioshkaDecorator {

    public GreenMatrioshkaDecorator(AMatrioshka aMatrioshka) {
        super(aMatrioshka);
    }

    @Override
    public String getName() {
        return "Green " + aMatrioshka.getName();
    }
}
