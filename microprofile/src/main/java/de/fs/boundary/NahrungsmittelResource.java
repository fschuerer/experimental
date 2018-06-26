package de.fs.boundary;

import de.fs.control.NahrungsmittelManager;
import de.fs.entity.Nahrungsmittel;
import de.fs.common.ResponseFactory;
import java.net.URI;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author XLKAFR
 */
//@Controller
@Path("nm")
public class NahrungsmittelResource {

    @Inject
    NahrungsmittelManager manager;

    @Inject
    Models models;
    
    @GET
    public Response all() {
        return Response.ok(ResponseFactory.entity(manager.getAll(), Nahrungsmittel.class)).build();
    }

    @POST
    public Response save(@Context UriInfo info, @Valid @NotNull Nahrungsmittel entity) {
        Nahrungsmittel savedEntity = manager.save(entity);
        URI location = info.getAbsolutePathBuilder().path(String.valueOf(savedEntity.getId())).build();
        return Response.created(location).build();
    }
    
    @GET
    @Controller
    @Path("input")
    public String eingabe() {
        return "nm.html";
    }
    
    @POST
    @Controller
    @Path("submit")
    public String submit(@BeanParam Nahrungsmittel entity) {
        manager.save(entity);
        return "redirect:nm/input";
    }
}
