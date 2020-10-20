package com.example.ecommerce.serviceimpl;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UsersRepository;
import com.example.ecommerce.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UsersServiceImpl implements UsersService {
   @Autowired
   UsersRepository usersRepository;

   private static final Logger logger = Logger.getLogger(UsersServiceImpl.class);

   public List<User> getList() {
      logger.debug("getList()");

      return usersRepository.findAll();
   }

   public Boolean saveUser(User user) {
      logger.debug("saveUser()");

      logger.debug("user: id=" + user.getId() + ", name=" + user.getName());

      usersRepository.save(user);

      return true;
   }

   public Boolean updateUser(User user) {
      logger.debug("updateUser()");

      logger.debug("user: id=" + user.getId() + ", name=" + user.getName());

      Optional<User> userToUpdate = usersRepository.findById(user.getId());

      if (!userToUpdate.isPresent()) {
         logger.error("Trying to update a nonexistent user record.");

         return false;
      }

      usersRepository.save(user);

      return true;
   }

   public User getItem(long id) {
      logger.debug("getItem()");

      logger.debug("id: " + id);

      Optional<User> user = usersRepository.findById(id);

      return user.isPresent() ? user.get() : null;
   }

   public Boolean deleteItem(long id) {
      logger.debug("deleteItem()");

      logger.debug("id: " + id);

      Optional<User> user = usersRepository.findById(id);

      if (!user.isPresent()) {
         logger.debug("The user for ID " + id + " entry does not exist.");

         return false;
      }

      usersRepository.deleteById(id);

      user = usersRepository.findById(id);

      return user.isPresent() ? false : true;
   }

   public User findUserByLogin(String login) {
      return usersRepository.findByLogin(login);
   }
}