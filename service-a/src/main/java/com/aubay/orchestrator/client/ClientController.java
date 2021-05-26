package com.aubay.orchestrator.client;

import com.aubay.orchestrator.api.*;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/client")
@ApplicationScoped
public class ClientController {

    @Inject
    @RestClient
    private InventoryClient inventoryClient;

    @Inject
    @RestClient
    private OrderClient orderClient;

    @Inject
    @RestClient
    private UserClient userClient;

    @POST
    @Path("/order/")
    public Response onClientSide(@RequestBody @Valid StartOrderCommand startOrderCommand) {
        if (!userClient.validateUser(startOrderCommand.getName()).getOk()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Long orderId = orderClient.startOrder(startOrderCommand);

        Result reserve = inventoryClient.reserve(new ReserveCommand(startOrderCommand.getProduct(), startOrderCommand.getQuantity()));
        if (reserve.getOk()) {
            orderClient.finishOrder(new FinishOrderCommand(orderId));
            return Response.ok("Order completed").build();
        } else {
            orderClient.rejectOrder(new RejectOrderCommand(orderId));
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
