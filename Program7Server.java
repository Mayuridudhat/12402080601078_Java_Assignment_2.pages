import java.io.*;
import java.net.*;

public class program7Server {
    public static void main(String[] args) {
        try {
            // FIXED: Added the missing semicolon here
            ServerSocket server = new ServerSocket(5000); 
            System.out.println("Server started... Waiting for client");
            
            Socket socket = server.accept();
            System.out.println("Client connected");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                
                // FIXED: Put the comment on a single line so it doesn't break the code
                out.println("Echo: " + message); // send back same message
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            
            socket.close();
            server.close();
            System.out.println("Server closed");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
