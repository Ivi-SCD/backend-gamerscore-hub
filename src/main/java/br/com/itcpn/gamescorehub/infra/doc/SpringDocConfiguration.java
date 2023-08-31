package br.com.itcpn.gamescorehub.infra.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(
                        new Info()
                                .title("GamerScoreHub API")
                                .version("1.0")
                                .description("An API to manage a site to ranking games: GamerScoreHub")
                                .contact(new Contact()
                                        .name("Backend Team")
                                        .email("ivipnascimento@hotmail.com"))
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("working on it")));
    }
}
