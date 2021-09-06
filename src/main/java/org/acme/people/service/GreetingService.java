package org.acme.people.service;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    private String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    public String greeting(String name) {
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        
        System.out.println("Available processors (cores): " + 
        Runtime.getRuntime().availableProcessors());
      
        /* Total amount of free memory available to the JVM */
        System.out.println("Free memory (Mbytes): " + 
        Runtime.getRuntime().freeMemory()/1024/1024);
      
        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        System.out.println("Maximum memory (bytes): " + 
        (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));
      
        /* Total memory currently in use by the JVM */
        System.out.println("Total memory (Mbytes): " + 
        Runtime.getRuntime().totalMemory()/1024/1024);
      
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
      
        /* For each filesystem root, print some info */
        for (File root : roots) {
          System.out.println("File system root: " + root.getAbsolutePath());
          System.out.println("Total space (Mbytes): " + root.getTotalSpace()/1024/1024);
          System.out.println("Free space (Mbytes): " + root.getFreeSpace()/1024/1024);
          System.out.println("Usable space (Mbytes): " + root.getUsableSpace()/1024/1024);
        }
        
        
        return "hello " + name + " from " + hostname + " with memory used=" + memory;
    }

}