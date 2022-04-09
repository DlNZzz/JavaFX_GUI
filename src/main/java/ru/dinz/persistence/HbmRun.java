package ru.dinz.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.dinz.model.Filial;
import ru.dinz.model.PDF;

import java.util.List;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            //Car car = Car.of("Toyota", new Timestamp(1459510232000L), "Sidorov Ivan");
            //User user = User.of(0, "qwe", null);
            //session.save(car);
            //session.save(user);
            Filial filial = Filial.of("Aboba");
            session.save(filial);
            List<Filial> filialList = session.createQuery("from ru.dinz.model.Filial").list();
            for (Filial f : filialList) {
                System.out.print(f);
            }

            //PDF pdf = findByIdPDF(0, sf);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static PDF findByIdPDF(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        PDF pdf = session.get(PDF.class, id);
        session.getTransaction().commit();
        session.close();
        return pdf;
    }
}