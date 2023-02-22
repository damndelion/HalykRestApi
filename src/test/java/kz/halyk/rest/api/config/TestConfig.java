package kz.halyk.rest.api.config;

import kz.halyk.rest.api.repository.UserRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {
  @Bean
  @Primary
  public UserRepository getUserRepository() {
    return Mockito.mock(UserRepository.class);
  }
}
