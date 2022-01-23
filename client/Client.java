package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    private Socket socket;                                                             

    //Socket y los datos para la conexi�n
    public  Client () throws IOException {
        socket = new Socket("localhost", 9876);
    }

    //
    public void connect () {

        //Iniciamos una instancia del objeto Scanner
        Scanner scanner = new Scanner(System.in);
        //Intentamos recibir los datos
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());     //Para recogida de datos del servidor
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());   //Para env�o de datos al servidor
            System.out.println(entrada.readUTF());                                      //Preguntamos el nombre
            salida.writeUTF(scanner.nextLine());                                        //Escriben el nombre
            System.out.println(entrada.readUTF());                                      //Preguntamos cantidad de tareas

            int numTareas = Integer.parseInt(scanner.nextLine());                       //Recogemos en n� de tareas
            salida.writeInt(numTareas);                                                 //Enviamos las tareas

        //Bucle   
            for (int i = 1 ; i <= numTareas; i++){
                System.out.println(entrada.readUTF());                                  //Recibo Introducci�n de la tarea
                System.out.println(entrada.readUTF());                                  //Recibo Introduce la descripci�n.
                salida.writeUTF(scanner.nextLine());                                    //Leemos y enviamos la desccripci�n
                System.out.println(entrada.readUTF());                                  //Recibo estado de la tarea
                salida.writeUTF(scanner.nextLine());                                    //Envio estado de la tarea
            }

            System.out.println(entrada.readUTF());                                      //Recibo "Listado de tareas"

            //Recibimos las tareas
            for (int i = 0; i<numTareas; i++){
                System.out.println(entrada.readUTF());
            }
            salida.close();
            entrada.close();
            socket.close();

        }catch (IOException ex){//En caso de no poder lanzamos la excepci�n
            System.err.println("La conexi�n ha fallado");
        }
       
    }
}

