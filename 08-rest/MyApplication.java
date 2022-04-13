package hw8;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("hwrest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
          packages("hw8");
      }
}

