package hiber.service;

import hiber.dao.UserDao;


import hiber.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUser(int id) {
      return userDao.getUser(id);
   }
   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }
   @Transactional
   @Override
   public void removeUser(User user) {
      userDao.removeUser(user);
   }

}
