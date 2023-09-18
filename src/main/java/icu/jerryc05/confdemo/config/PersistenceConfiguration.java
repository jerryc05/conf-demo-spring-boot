package icu.jerryc05.confdemo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
  // @Bean
  // DataSource dataSource() {
  //   System.out.println("PersistenceConfiguration.dataSource()");
  //   return DataSourceBuilder.create().url(
  //       "jdbc:mysql://localhost:3306/conference_demo").build();
  // }
}
