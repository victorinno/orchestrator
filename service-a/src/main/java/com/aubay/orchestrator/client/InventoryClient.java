package com.aubay.orchestrator.client;

import com.aubay.orchestrator.api.ReserveCommand;
import com.aubay.orchestrator.api.Result;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8082/inventory")
@ApplicationScoped
public interface InventoryClient {

    @POST
    @Path("/reserve")
    Result reserve(ReserveCommand reserveCommand);
}
