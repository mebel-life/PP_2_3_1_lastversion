//package hiber;
//
//
//import hiber.config.DatabaseConfig;
//import hiber.entity.User;
//import hiber.service.UserService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class MainApp {
//   public static void main(String[] args) throws SQLException {
//      AnnotationConfigApplicationContext context =
//            new AnnotationConfigApplicationContext(DatabaseConfig.class);
//
//      UserService userService = context.getBean(UserService.class);
//      User kolya = new User("kolya", "shapkin", 21, "peta@bk.ru","paroll55");
//      userService.add(new User("peta", "ivanov", 20, "peta@bk.ru","paroll"));
//      userService.add(new User("vasya", "maksimov", 33, "vasya@bk.ru","paroll22"));
//      userService.add(new User("katay", "sidorov", 10, "va@bk.ru","paroll33"));
//      userService.add(new User("vova", "ivanov", 11, "sya@bk.ru","paroll44"));
//      userService.add(kolya);
//
////      userService.removeUser(kolya);
//
//
//      System.out.println(userService.getUser(2).toString());
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println(user.toString());
//         System.out.println();
//      }
//
//      System.out.println(userService.getUser(2).toString());
//
//      context.close();
//   }
//}
