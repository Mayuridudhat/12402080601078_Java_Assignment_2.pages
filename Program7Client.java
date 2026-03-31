import java.io.*;
import java.net.*;
import java.util.*;

public class program7Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            
            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = sc.nextLine();
                out.println(message); // send to server
                
                String response = in.readLine();
                System.out.println("Server: " + response);
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            
            // FIXED: Closed the scanner to prevent resource leaks
            sc.close(); 
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
