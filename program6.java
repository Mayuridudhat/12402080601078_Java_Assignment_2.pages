import java.io.File;

public class program6 {
    public static void main(String[] args) {
        // Points to the current directory where the program is running
        String directoryPath = "."; 
        
        File directory = new File(directoryPath);

        System.out.println("=== Files in Directory: " + directory.getAbsolutePath() + " ===");

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("[File] " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("[Dir]  " + file.getName());
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
