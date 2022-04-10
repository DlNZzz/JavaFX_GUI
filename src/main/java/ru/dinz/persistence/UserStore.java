package ru.dinz.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.dinz.model.User;

import java.util.List;
import java.util.function.Function;

public class UserStore {

    private static final UserStore INST = new UserStore();

    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    private static final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

    public static UserStore instOf() {
        return INST;
    }

    public List<User> findAll() {
        return this.tx(
                session -> session.createQuery("from User").list()
        );
    }

    public void add(User user) {
        this.tx(
                session -> session.save(user)
        );
    }

    public User get(int id) {
        return this.tx(
                session -> session.get(User.class, id)
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
