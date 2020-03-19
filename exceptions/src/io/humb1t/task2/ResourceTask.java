package io.humb1t.task2;

class ResourceTask {
    public static void main(String[] args) {
        try (SomeResource firstResource = new SomeResource(1);
             SomeResource secondResource = new SomeResource(2)) {
            firstResource.doIt();
            secondResource.doIt();
        } finally {
            System.out.println("finally-block goes after try-with-resources");
            System.out.println("The resources are closed in the reverse order from which they were opened");
        }
    }
}
