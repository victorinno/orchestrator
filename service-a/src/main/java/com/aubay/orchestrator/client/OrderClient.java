package com.aubay.orchestrator.client;

import com.aubay.orchestrator.api.FinishOrderCommand;
import com.aubay.orchestrator.api.RejectOrderCommand;
import com.aubay.orchestrator.api.Result;
import com.aubay.orchestrator.api.StartOrderCommand;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8081/order")
@ApplicationScoped
public interface OrderClient {
    @POST
    @Path("/start")
    Long startOrder(StartOrderCommand command);

    @POST
    @Path("/reject")
    Result rejectOrder(RejectOrderCommand rejectOrderCommand);

    @POST
    @Path("/finish")
    Result finishOrder(FinishOrderCommand finishOrderCommand);
}
