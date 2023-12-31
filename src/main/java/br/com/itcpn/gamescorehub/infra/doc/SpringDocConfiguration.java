package br.com.itcpn.gamescorehub.infra.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

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
                                        .url("working on it")))
                .tags(Arrays.asList(
                        new Tag().name("Users").description("Operations about users"),
                        new Tag().name("Games").description("Operations about games"),
                        new Tag().name("Platforms").description("Operations about platforms"),
                        new Tag().name("Categories").description("Operations about categories")
                ));
    }
}
