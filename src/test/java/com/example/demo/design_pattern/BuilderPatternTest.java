package com.example.demo.design_pattern;

import com.example.demo.design_pattern.model.Employee;
import com.example.demo.design_pattern.model.User;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {

    @Test void employeeBuilder() {
        Employee employee = new Employee.Builder()
                .name("baeldung")
                .age(29)
                .department("Builder Pattern")
                .build();
        System.out.println(employee);
    }

    @Test void userBuilder() {
        User user = new User.Builder()
                .username("Jon")
                .password("22738022275")
                .build();
        System.out.println(user);
    }
}