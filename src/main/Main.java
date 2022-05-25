package main;

import connection.Connection;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            new Connection();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}
