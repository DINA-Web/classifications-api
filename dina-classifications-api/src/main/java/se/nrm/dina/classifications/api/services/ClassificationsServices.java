/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.services;
    
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.nrm.dina.classifications.api.logic.ClassificationsLogic; 
import se.nrm.dina.classifications.api.logic.exceptions.ClassificationsException;

/**
 *
 * @author idali
 */
@Path("/api/v0.1")
public class ClassificationsServices {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Inject
    ClassificationsLogic logic;

    // "Peromyscus interparietalis"
    @GET
    @Path("/search")
    @Produces(MediaType.TEXT_PLAIN)
    public Response get(@Context HttpServletRequest req, @QueryParam("scientificName") String scientificName) {
        
        logger.info("get : {}", scientificName);
         
        try {
            JsonObject json = logic.getNameSearchResult(scientificName, req.getRequestURL().toString());  
            return json == null ? Response.status(Response.Status.NOT_FOUND).build() : Response.ok(json.toString()).build();
        } catch(ClassificationsException ce) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } 
    }
}
