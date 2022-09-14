package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void dropUsersTable() {
//        String drop = "DROP TABLE IF EXISTS User ";
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            session.createSQLQuery(drop).executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
//        String sqlDeleteString = "delete User where id = :param";
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            User user = session.get(User.class, id);
//            session.delete(user);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {

        return (List<User>) entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            String hql = String.format("delete from User");
//            session.createQuery(hql).executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
    }
}
