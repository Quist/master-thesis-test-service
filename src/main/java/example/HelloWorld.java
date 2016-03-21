package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Arrays;

@WebService
public class HelloWorld {

    public static void main(String args[]) {
        if (args.length < 1) {
            printUsage();
            System.exit(1);
        }

        String port = args[0];
        String address = "http://0.0.0.0:" + port + "/";
        Endpoint.publish(address, new HelloWorld());
        System.out.println("Service listening on port: " + port);
    }

    static void printUsage(){
        System.out.println("usage: HelloWorld port");
    }

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        System.out.println("Received hello world request");
        String result = "Hello, world, from " + from;
        return result;
    }

    @WebMethod
    public String requestMessage(int size) {
        System.out.println("Received message request");
        char[] chars = new char[size];
        Arrays.fill(chars, 'a');

        String result = new String(chars);
        System.out.println("Created payload");
        return result;
    }
}
