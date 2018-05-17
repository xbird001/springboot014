package springboot010;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;


@SpringBootConfiguration
@EnableConfigurationProperties(value=DBPropeties.class)
public class MyDataSource {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource druidDataSource(DBPropeties dbProperties) {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(dbProperties.getDriverClassName());
		dds.setUrl(dbProperties.getUrl());
		dds.setUsername(dbProperties.getUsername());
		dds.setPassword(dbProperties.getPassword());
		return dds;
	}

}
