package org.example.exerciceapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exerciceapi.model.Voiture;
import org.example.exerciceapi.service.CarService;

import java.util.List;

@Path("/cars")
public class CarResource {

    private CarService carService = new CarService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture getOneCar(@PathParam("id") int id) {
        return carService.getVoiture(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> getAllCars() {
        return carService.getVoitures();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture createCar(Voiture voiture) {
        carService.addVoiture(voiture);
        return voiture;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture updateCar(@PathParam("id") int id, Voiture voiture) {
        if (voiture.getId() != id) {
            throw new BadRequestException("ID in URL does not match ID in Voiture object");
        }
        return carService.updateVoiture(voiture);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCar(@PathParam("id") int id) {
        carService.deleteVoiture(id);
    }
}