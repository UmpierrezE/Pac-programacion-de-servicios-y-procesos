package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //Atributos
    private final int puerto = 9876;           //Puerto
    private ServerSocket servidor;               //Servidor
    private Socket cliente;                     //Socket para comunicarnos

    //Constructor de la clase
    public Server () throws IOException {
        servidor = new ServerSocket(puerto);     //Inicializamos el Socket en el puerto que corresponda
        cliente = new Socket();                 //Inicializamos el Socket
    }

    //Conectamos con el cliente
    public void connect() throws IOException {
        while (true){                          //Bucle que se mantiene hasta el final de la aplicaci�n
            cliente = servidor.accept();          //Esperamos aceptando la petici�n de un cliente

            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF("Hola, �Cu�l es tu nombre?");
            System.out.println(entrada.readUTF());
            salida.writeUTF("�Cu�ntas tareas deseas realizar?");

            //Guardamos n de tareas
            int numeroDeTareas = entrada.readInt();
            System.out.println(numeroDeTareas);

            //Array de tareas
            Tarea [] arrayTareas = new Tarea[numeroDeTareas];

            //Recogemos las tareas a realizar
            for (int i = 1; i <= numeroDeTareas; i++ ){
                Tarea miTarea = new Tarea();
                salida.writeUTF("Tarea " + i);
                salida.writeUTF("Introduce la descripci�n: ");
                miTarea.setDescripcion(entrada.readUTF());                 //Recibo la descripci�n
                salida.writeUTF("Introduce el estado de la tarea: ");
                miTarea.setEstado(entrada.readUTF());                      //Recibo el estado de la tarea
                arrayTareas[i-1] = miTarea;
            }

            salida.writeUTF("Lista de tareas: ");
            for (int i = 0; i <numeroDeTareas; i++){                            //Con este bucle env�o al cliente strings con las tareas
                salida.writeUTF("Tarea: " + arrayTareas[i].getDescripcion() + ", con estado " + arrayTareas[i].getEstado());
            }
         
        }
    
    }
}

