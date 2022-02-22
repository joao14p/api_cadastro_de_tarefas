package com.viceri.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    private static final String GROUP = "backend-api";
    private static final String SCHEME_KEY = "OAuth2";
    private String oAuthServerTokenUri = "/oauth-server/oauth/token";

    @Bean
    public GroupOpenApi groupOpenApi() {
        return GroupedOpenApi.builder().group(GROUP).pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(apiInfo()).addSecurityItem(new SecurityRequirement().addList(SCHEME_KEY, "global"))
                .components(new Components().addSecuritySchemes(SCHEME_KEY, getSecurityScheme()));
    }

    private Info apiInfo() {
        return new Info().title("Backend Spring - Viceri API").description("Viceri API").version("v1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(new Contact().name("João Paulo Dantas").url("https://github.com/joao14p")
                        .email("joaopaulodantasbernardo@gmail.com"));
    }

    private SecurityScheme getSecurityScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.OAUTH2)
                .flows(new OAuthFlows().password(new OAuthFlow().tokenUrl(oAuthServerTokenUri)));
    }
}
