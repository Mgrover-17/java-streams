package com.bridgelabz.Console;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadUserInput {
    public static void main(String[] args) {
        try(
                BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
                FileWriter writer=new FileWriter("user_data",true);
                ){
            System.out.print("Enter your Name: ");
            String name = reader.readLine();

            System.out.print("Enter your Age: ");
            String age = reader.readLine();

            System.out.print("Enter your Favorite Programming Language: ");
            String programLanguage = reader.readLine();
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + programLanguage + "\n");
            writer.write("");



            System.out.println("User data saved successfully in " + "user_data");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
