/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.eltex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());

        testUser();
        testDeveloper();
        testManager();
    }

    public static void testUser() throws IOException {
        User user = new User(1, "Alex");
        System.out.println(user.toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user.json"), user);

        User user1 = mapper.readValue(new File("user.json"), User.class);
        System.out.println(user1.toString());
    }

    public static void testDeveloper() throws IOException {
        Developer developer = new Developer(1, "Alex", List.of("C", "C++"));
        System.out.println(developer.toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("developer.json"), developer);

        Developer developer1 = mapper.readValue(new File("developer.json"), Developer.class);
        System.out.println(developer1.toString());
    }

    public static void testManager() throws IOException {
        Manager manager = new Manager(1, "Alex", 3);
        System.out.println(manager.toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("manager.json"), manager);

        Manager manager1 = mapper.readValue(new File("manager.json"), Manager.class);
        System.out.println(manager1.toString());
    }
}
