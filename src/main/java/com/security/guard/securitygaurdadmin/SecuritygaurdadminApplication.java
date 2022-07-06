package com.security.guard.securitygaurdadmin;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.security.guard.securitygaurdadmin.configuration.FileStorageProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableJpaRepositories("com.security.guard.securitygaurdadmin.repository*")
@Configuration
public class SecuritygaurdadminApplication {

	@Value("${file.upload-dir}")
	String UPLOAD_FOLDER;
	
	public static void main(String[] args) {
		SpringApplication.run(SecuritygaurdadminApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}
	
	@Bean
	public FileStorageProperties getFileStorage() {

		return new FileStorageProperties();

	}

    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

	@PostConstruct
	public void creatFolder() {
		// String folder
		// =ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/").toString();
		File file = new File(UPLOAD_FOLDER );
		if (!file.exists()) {
			System.out.println("Does not Exit. Creaitng folder");
			file.mkdir();

		} else {
			System.out.println("Does  Exit. ");

		}
	}
}
