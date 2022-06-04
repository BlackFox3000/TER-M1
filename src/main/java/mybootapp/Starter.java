package mybootapp;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import mybootapp.model.Course;
import mybootapp.repo.CourseRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CourseRepository.class)
@EntityScan(basePackageClasses = Course.class)
public class Starter implements WebMvcConfigurer {

	public static void main(String[] args) {
		fakerData();
		SpringApplication.run(Starter.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("--- addResourceHandlers");
		registry.addResourceHandler("/webjars/**")//
				.addResourceLocations("/webjars/");
	}

	public static void fakerData(){
		FakerData fakerData = new FakerData();
		System.out.println("email : "+fakerData.users.get(0).getEmail());
	}



}
