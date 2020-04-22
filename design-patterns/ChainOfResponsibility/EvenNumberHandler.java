package ChainOfResponsibility;

public class EvenNumberHandler extends ABaseHandler {
    @Override
    public boolean validate(Request request) {
        return request.getValue() % 2 == 0;
    }
}
