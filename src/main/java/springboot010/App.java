package springboot010;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude={ErrorMvcAutoConfiguration.class})
@EnableTransactionManagement
public class App {
	
	public static void main(String[] args) throws SQLException {
		
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
/*		context.getBean(UserDao.class).saveClass("4","三(2)班","中华路");
		System.out.println(context.getBean(DataSource.class).getClass());*/
		UserDao userDao = context.getBean(UserDao.class);
		userDao.savePersonUser();
		
		
	}

}
