package pt.vcyst.proj.api;

import java.util.concurrent.CompletableFuture;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Stateless
@Path("api")
public class Enpoint {

    @Inject
    Service service;

    // @Resource
    // ManagedExecutorService ex;

    @GET
    public void init(@Suspended AsyncResponse response) {
        // response.setTimeout(1, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(service::invoke).thenAccept(response::resume);
        // response.resume("ok" + this.service.invoke());
    }
}
