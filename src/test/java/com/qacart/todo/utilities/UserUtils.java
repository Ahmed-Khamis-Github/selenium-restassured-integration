package com.qacart.todo.utilities;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {

    public User generateRandomUsers()

    {

        String firstName = new Faker().name().firstName() ;
        String lastName = new Faker().name().lastName() ;
        String email = new Faker().internet().emailAddress() ;
        String password = new Faker().internet().password() ;

        User user = new User(firstName,lastName,email,password) ;

        return user ;





    }
}
