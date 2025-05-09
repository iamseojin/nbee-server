package com.software.newbii.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  /**
   * 인증이 필요 없는 공개 API 설정.
   * SecurityScheme · SecurityRequirement 제거.
   */
  @Bean
  public OpenAPI openAPI() {

    return new OpenAPI()
        .servers(List.of(
            new Server()
                .url("http://localhost:7070")
                .description("Local Server"),
            new Server()
                .url("http://43.200.125.51:7070")
                .description("Main 서버")
        ));
  }
}
