package Decorator;

public class PurpleMatrioshkaDecorator extends MatrioshkaDecorator {

    public PurpleMatrioshkaDecorator(AMatrioshka aMatrioshka) {
        super(aMatrioshka);
    }

    @Override
    public String getName() {
        return "Purple " + aMatrioshka.getName();
    }
}