package com.DoctorAppointment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@OpenAPIDefinition(
		info = @Info(title = "Doctor Appointment Application APIs",
				version = "1.0.0",
				description = "It is a Doctor appointment APIs documentation"),
		servers=@Server(url = "http://localhost:8080",
				description = "Doctor Appointment APIs")

)
@SpringBootApplication
public class DoctorAppointmentApplication {


	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
