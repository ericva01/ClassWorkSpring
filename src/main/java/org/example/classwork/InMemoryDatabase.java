package org.example.classwork;

import org.example.classwork.model.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InMemoryDatabase {
    @Bean
    public List<Students> studentsList() {
        return List.of(
                new Students(1,"Eric Va",50.5,"Male"),
                new Students(2,"John Smith",50.1,"Male"),
                new Students(3,"Jacky Chan",100.0,"Male"),
                new Students(4,"Chan Romdoul",50.1,"Female"),
                new Students(5,"Soy Sreyheng",50.1,"Female"),
                new Students(6,"Heng Hong",56.5,"Male"),
                new Students(7,"John Jack",59.1,"Male"),
                new Students(8,"Tony Stack",150.0,"Male"),
                new Students(9,"Bill Musk",56.1,"Male"),
                new Students(10,"Ko ko",160.0,"Male")
        );
    }
}
