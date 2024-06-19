package org.example.exerciceapi.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exerciceapi.model.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@ApplicationScoped
public class CarService {

    private SessionFactory sessionFactory;

    public CarService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Voiture> getVoitures() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT v FROM Voiture v", Voiture.class).getResultList();
        }
    }

    public Voiture getVoiture(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Voiture.class, id);
        }
    }

    public void addVoiture(Voiture voiture) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(voiture);
            session.getTransaction().commit();
        }
    }

    public Voiture updateVoiture(Voiture voiture) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(voiture);
            session.getTransaction().commit();
            return voiture;
        }
    }

    public void deleteVoiture(int id) {
        try (Session session = sessionFactory.openSession()) {
            Voiture voiture = getVoiture(id);
            if (voiture != null) {
                session.beginTransaction();
                session.delete(voiture);
                session.getTransaction().commit();
            }
        }
    }
}