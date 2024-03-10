package Automate_selenium.Phase_5_Practice_Project_1_Problem_13;

import java.io.File;
import java.io.IOException;

import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.internal.RemoteProxy;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GridConfigurationUsingJSON {
    public static void main(String[] args) throws IOException {
        // Load the JSON file
        File configFile = new File("B:\\Phase-3-Spring\\Phase_5_Practice_Project_1_Problem_13\\grid-config.json");

        // Create an instance of ObjectMapper to parse JSON
        ObjectMapper mapper = new ObjectMapper();
        GridHubConfiguration hubConfig = mapper.readValue(configFile, GridHubConfiguration.class);

        // Start the hub
        Hub hub = new Hub(hubConfig);
        hub.start();

        // Start the nodes
        GridRegistry registry = hub.getRegistry();
        for (RemoteProxy proxy : registry.getAllProxies()) {
            if (proxy.getConfig().role.equals("node")) {
                hub.getRegistry().add(proxy);
            }
        }

        // Display hub information
        System.out.println("Hub URL: " + hub.getRegistrationURL());
        System.out.println("Hub Configuration: " + hub.getConfiguration());
    }
}








//package Automate_selenium.Phase_5_Practice_Project_1_Problem_13;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.grid.common.GridRole;
//import org.openqa.grid.internal.GridRegistry;
//import org.openqa.grid.internal.RemoteProxy;
//import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
//import org.openqa.grid.web.Hub;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class GridConfigurationUsingJSON {
//    public static void main(String[] args) throws IOException {
//        // Load the JSON file
//        File configFile = new File("B:\\Phase-3-Spring\\Phase_5_Practice_Project_1_Problem_13\\grid-config.json");
//
//        // Create an instance of ObjectMapper to parse JSON
//        ObjectMapper mapper = new ObjectMapper();
//        GridHubConfiguration hubConfig = mapper.readValue(configFile, GridHubConfiguration.class);
//
//        // Start the hub
//        Hub hub = new Hub(hubConfig);
//        hub.start();
//
//        // Start the nodes
//        GridRegistry registry = hub.getRegistry();
//        for (RemoteProxy proxy : registry.getAllProxies()) {
//            if (proxy.getConfig().getRole().equals(GridRole.NODE)) {
//                hub.getRegistry().add(proxy);
//            }
//        }
//
//        // Display hub information
//        System.out.println("Hub URL: " + hub.getRegistrationURL());
//        System.out.println("Hub Configuration: " + hub.getConfiguration());
//    }
//}
//
//
