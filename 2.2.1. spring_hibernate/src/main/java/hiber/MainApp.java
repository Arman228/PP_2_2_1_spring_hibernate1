package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);




        Car car1 = new Car("Bmw", 3);
        Car car2 = new Car("Mers", 2);
        Car car3 = new Car("Opel", 5);


        carService.add(car1);
        carService.add(car2);
        carService.add(car3);

        User user1 = new User("Misha","Mishanov","@dsdssd");
        User user2 = new User("Ser","Serov","@dsd3sd");
        User user3 = new User("Mids","Mifanov","@dfdfds");

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);


        userService.add(user1);
        userService.add(user2);
        userService.add(user3);





        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();

        }
        System.out.println(userService.findUser("Bmw", 3));
        context.close();
    }
}
