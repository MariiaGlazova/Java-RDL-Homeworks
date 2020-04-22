package Decorator;

public class MatrioshkaDecorator extends AMatrioshka {
    protected AMatrioshka aMatrioshka;

    public MatrioshkaDecorator(AMatrioshka aMatrioshka) {
        this.aMatrioshka = aMatrioshka;
    }
}
