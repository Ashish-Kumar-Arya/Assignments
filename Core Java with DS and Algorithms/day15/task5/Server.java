package assignments.day15.task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ServerSocket serverSocket=new ServerSocket(1234);
            
           
            while (true) {
                Socket socket=serverSocket.accept();
                ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
                System.out.println("New client connected");
                Operation op=(Operation) input.readObject();
            System.out.println("received from client: "+op);
            String response="";
            switch (op.getO()) {
                case '+':
                     response=Integer.toString(op.getA()+op.getB());
                    break;
                case '-':
                    response=Integer.toString(op.getA()-op.getB());
                    break;
                case '*':
                    response=Integer.toString(op.getA()*op.getB());
                    break;
                case '/':
                    response=Integer.toString(op.getA()/op.getB());
                    break;
                default:
                    response="Invalid operator";
            }
            output.writeObject(response);
            }       
    }
}