spring boot jdbc
	1、spring boot jdbc
		1.1、加入数据库驱动
		1.2、配置application.properties文件中的数据源配置
			spring.datasource.driverClassName=oracle.jdbc.driver.OracleDriver
			spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:XE
			spring.datasource.username=HIBER
			spring.datasource.password=admin
			#这个地方如果不配置，则默认用的tomcat的数据源，如果配置就需要在pom.xml配置上他的依赖jar包
				#spring boot默认支持五种数据源：
				DataSourceConfiguration.Tomcat.class, DataSourceConfiguration.Hikari.class,
				DataSourceConfiguration.Dbcp.class, DataSourceConfiguration.Dbcp2.class,
				DataSourceConfiguration.Generic.class
			spring.datasource.type=com.zaxxer.hikari.HikariDataSource
		1.3、具体可以配置的属性可参见org.springframework.boot.autoconfigure.jdbc.DataSourceProperties.class里面的配置项
	
	2、spring boot jdbc template
		当我们配置了数据源后，spring boot将自动的帮我们配置好DataSource和JdbcTemplate两个类，具体参见如下类：springboot010.UserDao.class
		
	3、自定义的数据源配置
		3.1、引入相关的数据源jar包依赖
		3.2、编写配置类，将指定的数据源返回给spring容器进行管理
		3.3、具体参见：springboot010.MyDataSource.class的使用方式
	3、事务的引入
		3.1、用注解开启对事务的支持@EnableTransactionManagement，在测试中发现好像不写明，也默认支持事务
		3.2、在特定的方法或者类上面标明注解@Transactional
		3.3、具体参见类：springboot010.UserDao.class 注意事务的传播特性