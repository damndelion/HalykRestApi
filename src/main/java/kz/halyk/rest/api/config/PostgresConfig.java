package kz.halyk.rest.api.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Postgres configs.
 */
@Configuration
@ComponentScan("kz.halyk.rest.api.config")
@EnableJpaRepositories(basePackages  = "kz.halyk.rest.api.repository")
public class PostgresConfig {

  /**
   * Postgres datasource configs.
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://0.0.0.0:5432/postgres");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");
    return dataSource;
  }

}
