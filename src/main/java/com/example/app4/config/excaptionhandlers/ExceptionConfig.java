package com.example.app4.config.excaptionhandlers;

import com.example.app4.utils.enums.AppProfiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Profile(AppProfiles.PROD)
@Configuration
public class ExceptionConfig {

	@Lazy
	@Bean
	private SQLException customSQLException() {
		return new SQLException("Sql Exception");
	}
}