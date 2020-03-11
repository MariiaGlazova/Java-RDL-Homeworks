package io.humb1t;

import java.util.ArrayList;

public class IncorrectConstructorTask {

    public static void main(String[] args) {
        Object[] store = new Object[1];
        User user;
        try {
            user = new User(1, "User", new ArrayList<>(), store);
        } catch (NullPointerException e) {
            System.out.println(store[0]);
        }
        user = new User();
        System.out.println(user.toString());
    }

    private static class User {
        private int id;
        private String name;
        private ArrayList<String> events;

        public User() {
        }

        public User(int id, String name, ArrayList<String> events, Object[] store) {
            store[0] = this;
            this.id = id;
            this.name = name;
            this.events = events;
            throw new NullPointerException();
        }
    }
}
