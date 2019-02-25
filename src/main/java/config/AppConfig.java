package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("dao")
public class AppConfig {

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			driverManagerDataSource.setUrl(
					"postgresql://lzcxfobqy:sY06qww_01TI7aB2ORFNBOg4zw9r_SBF@stampy.db.elephantsql.com:5432/zcxfobqy");
			driverManagerDataSource.setDriverClassName("org.postgresql.Driver");

		return driverManagerDataSource;
	}
}
