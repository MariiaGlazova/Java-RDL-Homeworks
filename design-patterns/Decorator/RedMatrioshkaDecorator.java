package Decorator;

class RedMatrioshkaDecorator extends MatrioshkaDecorator {

    public RedMatrioshkaDecorator(AMatrioshka aMatrioshka) {
        super(aMatrioshka);
    }

    @Override
    public String getName() {
        return "Red " + aMatrioshka.getName();
    }
}
