package Decorator;

public class Main {
    public static void main(String[] args) {
        AMatrioshka matrioshka = new GreenMatrioshkaDecorator(new RedMatrioshkaDecorator(new PurpleMatrioshkaDecorator
                (new RedMatrioshkaDecorator(new BlueMatrioshkaDecorator(new Matrioshka())))));
        System.out.println(matrioshka.getName());

        System.out.println("1." + new Matrioshka().getName());
        System.out.println("2." + new BlueMatrioshkaDecorator(new Matrioshka()).getName());
        System.out.println("3." + new PurpleMatrioshkaDecorator(new Matrioshka()).getName());
        System.out.println("4." + new BigMatrioshkaDecorator(new RedMatrioshkaDecorator(new Matrioshka())).getName());
        System.out.println("5." + new BigMatrioshkaDecorator(new GreenMatrioshkaDecorator(new Matrioshka())).getName());
    }
}
