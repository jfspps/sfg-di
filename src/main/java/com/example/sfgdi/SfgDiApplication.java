package com.example.sfgdi;

import com.example.sfgdi.controllers.ConstructorInjectedController;
import com.example.sfgdi.controllers.MyController;
import com.example.sfgdi.controllers.PropertyInjectedController;
import com.example.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.naming.ldap.Control;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        //Spring Context handles the instantiation of a controller (flagged by the class MyController with @ annotation)

        //MyController class seeks the dependencies (libraries/tools/settings needed to function) which Spring Context
        // provides (injects). Other objects can inject dependencies in addition to Spring. The responsibility of how to
        // provide/inject dependencies lies with Spring

        //Java POJOs which utilise database tables such as H2 (SQL engine written in Java; often handled by ORM mapping
        // framework, Hibernate) or MySQL are handled with DIs in mind. The Spring framework handles the background
        // provision of dependencies allowing the coder to focus on the business logic

        //DIs cover code written. Inversion of Control is the process where Spring handles injections at run-time.



        ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

        //cast MyController and ask Spring Context to create a Bean in the context of MyController
        //convention of using the class name with first letter lowercase is applied here
        MyController controller = (MyController) context.getBean("myController");

        String greeting = controller.sayHi();

        System.out.println(greeting);

        System.out.println("------ Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor" );
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
