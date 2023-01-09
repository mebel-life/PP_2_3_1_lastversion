package hiber.dao;

import hiber.entity.User;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
@Transactional
public class UserDaoImp implements UserDao {
   @PersistenceContext
   EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> listUsers() {
      List<User> user = entityManager.createQuery("from users", User.class).getResultList();
      return user;
   }
}

