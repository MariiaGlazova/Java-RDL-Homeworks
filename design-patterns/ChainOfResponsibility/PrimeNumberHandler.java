package ChainOfResponsibility;

import java.math.BigInteger;

public class PrimeNumberHandler extends ABaseHandler {

    @Override
    public boolean validate(Request request) {
        return new BigInteger(String.valueOf(request.getValue())).isProbablePrime(100);
    }
}
