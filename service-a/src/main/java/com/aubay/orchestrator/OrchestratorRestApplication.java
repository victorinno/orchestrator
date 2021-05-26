package com.aubay.orchestrator;


import com.aubay.orchestrator.client.ClientController;
import com.aubay.orchestrator.config.ConfigTestController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 *
 */
@ApplicationPath("/data")
public class OrchestratorRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();
        classes.add(ConfigTestController.class);
        classes.add(ClientController.class);

        return classes;
    }
}
