package server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Server servidor = new Server(); //Creamos el servidor
        servidor.connect();	//Lo conectamos
    }
}
