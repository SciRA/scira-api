package scira.rest;

import org.springframework.beans.factory.annotation.Autowired;
import scira.sparql.controller.VirtuosoController;
import virtuoso.jena.driver.VirtGraph;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SilviuG on 26.11.2017.
 */
@Path("/search")
public class RestApi {

    @Autowired
    private VirtGraph virtGraph;

    @Autowired
    private VirtuosoController virtuosoController;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/paper")
    public Response search() {
        try {
            Connection connection = virtGraph.getConnection();
            Statement statement = connection.createStatement();
            virtuosoController.save(new Object());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity("Search").build();
    }
}
