package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloWorld {

    public static void main(String args[]) {
        if (args.length < 1) {
            printUsage();
            System.exit(1);
        }

        String port = args[0];
        String address = "http://localhost:" + port + "/ws/hello";
        Endpoint.publish(address, new HelloWorld());
        System.out.println("Service listening on address " + address);
    }

    static void printUsage(){
        System.out.println("usage: HelloWorld port");
    }

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }
}
