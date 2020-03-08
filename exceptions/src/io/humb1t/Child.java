package io.humb1t;

import java.nio.file.AccessDeniedException;

public class Child extends Parent {

    public Child() throws LifeCycleActionExecutionException, AccessDeniedException {
    }

    @Override
    public void throwOnlyOneException() throws LifeCycleActionExecutionException, AccessDeniedException, ImpossibleCycleActionException {
    }
}
