import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class RPCClient {

    private final PrintStream printStream;			//Initialize it as sockets i/p & O/p stream
    
    public RPCClient(String ipAddress, int port) throws IOException {

        Socket rpcClient = new Socket(ipAddress, port);

        new Thread(() -> {
            
                BufferedReader reader = null;
				try {
					reader = new BufferedReader(new InputStreamReader(rpcClient.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                String line;

                try {
					while ((line = reader.readLine()) != null) {
					    System.out.println("Server response : " + line);
    System.out.print("\nCommands [add, sub, mul, div, mod, exit] : ");     //Number of commmands possible               
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
        }).start();

        printStream = new PrintStream(rpcClient.getOutputStream(), true);

    }

    public void sendMessage(String operation) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter 1st number : ");
        int f1 = scan.nextInt();

        System.out.print("Enter 2nd number : ");
        int s1 = scan.nextInt();

        printStream.println(operation + ":" + f1 + ":" + s1);  //PrintStream is initialized with servers o/p stream

    }

    public static void main(String[] args) {

        try {
   Scanner sc = new Scanner(System.in);
   
   System.out.print("Enter server ip address : ");
   String ipAddress = sc.nextLine();
   
   System.out.print("Enter connection port : ");
   int port = sc.nextInt();
   
            RPCClient client = new RPCClient(ipAddress, port);
            System.out.println("\n Connected to server \n");

   System.out.print("Commands [add, sub, mul, div, mod, exit] : ");

            while (true) {
    
    sc = new Scanner(System.in);
    
                String command = sc.nextLine();

                if (command.equals("exit")) {
                    System.exit(0);
                }

                client.sendMessage(command);
    
    System.out.println();

            }
        } catch (IOException ex) {
            System.err.println("\nUnable to connect! \n\n Please try again");
        }

    }

}