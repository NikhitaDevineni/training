package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Restuarnt;
import com.example.demo.ifaces.RestuarntRepository;
import com.example.demo.service.RestaurntService;

@SpringBootApplication
public class RestaurntServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(RestaurntServiceApplication.class, args);
		//ctx.getBean(RestaurntService.class).findAll().forEach(System.out:: println);
		RestaurntService service=ctx.getBean(RestaurntService.class);

	int key=3;
	switch(key) {
	case 1:
	service.findAll().forEach(System.out::println);
	break;
	case 2:
		 System.out.println(service.findById(2022));
		 break;
	case 3:
		System.out.println(service.remove(2022));
		 break;
	case 4:
		Restuarnt objToUpdate=ctx.getBean("updateBean",Restuarnt.class);
		System.out.println(service.update(objToUpdate));
		break;
	case 5:
		service.findByName("bang").forEach(System.out::println);
		break;
	case 6:
		service.fetchUsingLocation("bellary").forEach(System.out::println);
		break;
	case 7:
		System.out.println("number of rows update"+service.updateRating(202, 4.2));
		break;
	case 8:service.fetchUsingRating(3.5).forEach(System.out::println);
		 default:
			 break;
	}
	ctx.close();
}

		 @Bean 
		public CommandLineRunner runner() {
		return new CommandLineRunner() {
				@Autowired
				RestuarntRepository repo;

				@Override
				public void run(String... args) throws Exception {
					
					repo.save(new Restuarnt(2022,"udpi","goa",4.7,LocalDate.of(2022,2,2)));
					repo.save(new Restuarnt(2033,"woodland","delhi",4.8,LocalDate.of(2022,3,3)));
					
					
				}
		 
	

		
			
		};

}

}
