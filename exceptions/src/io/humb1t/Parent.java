package io.humb1t;

import java.nio.file.AccessDeniedException;

public class Parent {

    public Parent() throws LifeCycleActionExecutionException {
    }

    public void throwOnlyOneException() throws LifeCycleActionExecutionException, AccessDeniedException, ImpossibleCycleActionException {
    }
}
