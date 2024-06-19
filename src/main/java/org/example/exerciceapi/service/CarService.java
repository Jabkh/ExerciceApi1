package org.example.exerciceapi.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exerciceapi.model.Voiture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarService {

    private static int cntCars = 0;
    private static List<Voiture> voitures = new ArrayList<>();

    public CarService() {
//        voitures.add(new Voiture(1, "Opel", 1962, "Beige"));
//        voitures.add(new Voiture(2, "Audi", 1983, "Bordeau"));
//        voitures.add(new Voiture(3, "Lada", 1985, "Marron"));
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public Voiture getVoiture(int id) {
        return voitures.stream().filter(voiture -> voiture.getId() == id).findFirst().orElse(null);
    }

    public void addVoiture(Voiture voiture) {
        if (voiture.getId() == 0) {
            voiture.setId(++cntCars);
        }
        voitures.add(voiture);
    }

    public Voiture updateVoiture(Voiture voiture) {
        int index = voitures.indexOf(getVoiture(voiture.getId()));
        if (index != -1) {
            voitures.set(index, voiture);
            return voiture;
        }
        return null;
    }

    public void deleteVoiture(int id) {
        voitures.removeIf(voiture -> voiture.getId() == id);
    }
}