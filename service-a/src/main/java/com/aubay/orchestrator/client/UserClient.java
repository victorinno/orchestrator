package com.aubay.orchestrator.client;

import com.aubay.orchestrator.api.Result;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient(baseUri = "http://localhost:8080/user")
@ApplicationScoped
public interface UserClient {

    @GET()
    @Path("/{name}/validate")
    Result validateUser(@PathParam("name") String name);
}
