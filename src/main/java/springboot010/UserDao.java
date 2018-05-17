package springboot010;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveClass(String id, String className, String classAddress) {
		String sql = "insert into t_class (id,class_name,class_address) values ('"
				+ id + "','" + className + "','" + classAddress + "')";
		jdbcTemplate.execute(sql);
	}
	
	/*@Transactional*/
	public void saveUser() {
		String sql  = "insert into t_user (id,user_name) values('200','user_周')";
		jdbcTemplate.execute(sql);
		throw new NullPointerException();
	}
	
	/*@Transactional*/
	public void savePerson() {
		String sql  = "insert into t_person (id,person_name) values('200','person_周')";
		jdbcTemplate.execute(sql);
	}
	@Transactional
	public void savePersonUser() {
		this.savePerson();
		this.saveUser();
	}

}
