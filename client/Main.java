package client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Client cliente = new Client();   //Creamos cliente
        cliente.connect();               //Conectamos cliente
    }
}
