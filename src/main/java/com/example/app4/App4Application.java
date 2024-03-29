package com.example.app4;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.app4.repository")
public class App4Application {

    public static void main(String[] args) {
        SpringApplication.run(App4Application.class, args);
    }

}

@Configuration
class AppConfig implements WebMvcConfigurer {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL TEST");

        Server prodServer = new Server();
        prodServer.setUrl(null);
        prodServer.setDescription("Server URL PROD");

        Contact contact = new Contact();
        contact.setEmail("xxxx@gmail.com");
        contact.setName("app4");
        contact.setUrl("https://www.example.com");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("App4 API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.")
                .termsOfService("https:/www.example.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        WebMvcConfigurer.super.addFormatters(registry);

        registry.addFormatterForFieldType(LocalDate.class, new Formatter<LocalDate>() {

            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DATE_FORMATTER);
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return DATE_FORMATTER.format(object);
            }

        });

        registry.addFormatterForFieldType(LocalDateTime.class, new Formatter<LocalDateTime>() {

            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, DATE_TIME_FORMATTER);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return DATE_TIME_FORMATTER.format(object);
            }

        });
    }

}