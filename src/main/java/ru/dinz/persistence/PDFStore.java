package ru.dinz.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.dinz.model.PDF;
import ru.dinz.model.PDF;

import java.util.List;
import java.util.function.Function;

public class PDFStore {

    private static final PDFStore INST = new PDFStore();

    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    private static final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

    public static PDFStore instOf() {
        return INST;
    }

    public List<PDF> findAll() {
        return this.tx(
                session -> session.createQuery("from PDF").list()
        );
    }

    public void add(PDF pdf) {
        this.tx(
                session -> session.save(pdf)
        );
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
