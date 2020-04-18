package ChainOfResponsibility;

public class DivideByThreeNumberHandler extends ABaseHandler {
    @Override
    public boolean validate(Request request) {
        return request.getValue() % 3 == 0;
    }
}
