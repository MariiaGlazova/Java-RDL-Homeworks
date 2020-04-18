package ChainOfResponsibility;

public class ErrorHandler extends ABaseHandler {
    @Override
    public boolean validate(Request request) {
        return true;
    }
}