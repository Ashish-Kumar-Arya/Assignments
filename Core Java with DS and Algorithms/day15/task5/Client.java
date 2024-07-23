package assignments.day15.task5;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String hostname="localhost";
        int port=1234;
        Socket socket=new Socket(hostname,port);
        ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
        Operation op=new Operation(12, 8, '-');
        output.writeObject(op);
        output.flush();
        String response=(String) input.readObject();
        System.out.println("Server response: "+response);
    }
}