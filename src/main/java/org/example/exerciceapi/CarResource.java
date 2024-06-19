package org.example.exerciceapi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.exerciceapi.model.Voiture;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarResource {

    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture getOneCar() {
        return new Voiture(1, "Tesla", 2022, "Rouge");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> getAllCars() {

        List<Voiture> voitures = new ArrayList<>();
        voitures.add(new Voiture(1, "Toyota", 2023, "Gris"));
        voitures.add(new Voiture(2, "Ford", 2020, "Noir"));
        voitures.add(new Voiture(3, "Mercedes", 1965, "Blanc"));
        return voitures;
    }
}
