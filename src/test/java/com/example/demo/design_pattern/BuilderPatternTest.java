package com.example.demo.design_pattern;

import com.example.demo.design_pattern.model.Employee;
import com.example.demo.design_pattern.model.User;
import com.example.demo.design_pattern.model.Visa;
import org.junit.jupiter.api.Test;

import java.util.Date;

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

    @Test void visaBuilder() {
        Visa visa = Visa.builder()
                .type("AffiliationAndRole")
                .asserted(new Date(1549680000))
                .value("faculty@med.stanford.edu")
                .source("https://grid.ac/institutes/grid.240952.8")
                .by("so")
                .build();
        System.out.println(visa);
    }
}