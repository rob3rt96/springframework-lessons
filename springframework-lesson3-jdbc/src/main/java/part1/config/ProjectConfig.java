package part1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "part1.repositories")
public class ProjectConfig {

    @Bean
    public DataSource dataSource() {        // We need this implementation of DataSource in the Context in order to connect to the database.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/demo");
        dataSource.setUsername("robertp1");
        dataSource.setPassword("Camaross969");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
