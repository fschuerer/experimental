package de.fs.boundary;

import de.fs.common.ResponseFactory;
import de.fs.control.NahrungsmittelManager;
import de.fs.control.RezeptManager;
import de.fs.entity.Einheit;
import de.fs.entity.NahrungMenge;
import de.fs.entity.Nahrungsmittel;
import de.fs.entity.Rezept;
import de.fs.entity.Zeitpunkt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author XLKAFR
 */
@Path("rezept")
public class RezeptResource {

    @Inject
    RezeptManager manager;
    
    @Inject
    NahrungsmittelManager nmManager;
            
    @Inject
    Models models;
    
//    @Inject
    Rezept current;
    
    public NahrungsmittelManager getNmManager() {
        return nmManager;
    }
    
    @GET
    public Response all() {
        return Response.ok(ResponseFactory.entity(manager.findAll(), Rezept.class)).build();
    }

    @GET
    @Controller
    @Path("input")
    public String eingabe() {
        models.put("nmManager", nmManager);
        models.put("zeitpunkte", Arrays.asList(Zeitpunkt.values()));
        current = new Rezept();
//        models.put("zutaten", Collections.emptyList());
//        current.setZutaten(new ArrayList<>());
//        NahrungMenge menge = new NahrungMenge();
//        menge.setRezept(current);
//        menge.setMenge(100);
//        current.getZutaten().add(menge);
//        menge = new NahrungMenge();
//        menge.setRezept(current);
//        menge.setMenge(200);
//        current.getZutaten().add(menge);
        models.put("current", current);
        return "/rezept.jsp";
    }

    @POST
    @Controller
    @Path("submit")
    public String submit(@BeanParam Rezept entity) {
        System.err.println(entity);
        //current.setName(entity.getName());
        //current.setZeitpunkt(entity.getZeitpunkt());
        manager.save(entity);
        return "redirect:rezept/input";
    }
    
    @Controller
    @POST
    @Path("add")
    public void add(@BeanParam ZutatFormBean entity) {
        System.err.println("ADd" + entity);
        Nahrungsmittel nm = nmManager.getById(entity.getNm());
        NahrungMenge menge = new NahrungMenge();
        menge.setMenge(entity.getMenge());
        menge.setNahrungsmittel(nm);
        current.getZutaten().add(menge);
    }
}
