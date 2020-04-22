package ChainOfResponsibility;

public abstract class ABaseHandler implements IHandler {
    IHandler next;

    @Override
    public void setNextHandler(IHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(Request request) {
        if (validate(request)) {
            System.out.println(request.getValue() + " is handled by " + this.getClass().getSimpleName());
        } else {
            if (this.next != null) {
                this.next.handle(request);
            }
        }
    }
}
