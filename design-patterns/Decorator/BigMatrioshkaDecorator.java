package Decorator;

public class BigMatrioshkaDecorator extends MatrioshkaDecorator {

    public BigMatrioshkaDecorator(AMatrioshka aMatrioshka) {
        super(aMatrioshka);
    }

    @Override
    public String getName() {
        return "Big " + aMatrioshka.getName();
    }
}