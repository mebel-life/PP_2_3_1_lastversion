package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User ("misha", "Lastname2", "user1@mail.ru");
      Car car = new Car ("volvo", 235);
      userService.add(user1);
      userService.add(car);
      //объеденение user и car
      userService.joinCarUser(user1, car);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}

//   Чтобы получить юзера, для инициализации запроса, писать не executeUpdate , а getSingleResult()
//        Если захотите использовать модель и серию, то в запросе ставьте and.
//        INNER JOIN в запросе тоже нет, обычный from и where.
