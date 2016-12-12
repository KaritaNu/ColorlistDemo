package fi.haagahelia.karitasp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.karitasp.domain.Category;
import fi.haagahelia.karitasp.domain.CategoryRepository;
import fi.haagahelia.karitasp.domain.Colorlist;
import fi.haagahelia.karitasp.domain.UserRepository;
import fi.haagahelia.karitasp.domain.colorRepository;
import fi.haagahelia.karitasp.domain.user;


@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner colorDemo(colorRepository brepository , CategoryRepository crepository , UserRepository urepository) {
		return (args) -> {
			log.info("Edit colors");
			crepository.save(new Category("CG"));
			crepository.save(new Category("DG"));
			crepository.save(new Category("GG"));
			crepository.save(new Category("LG"));
			crepository.save(new Category("CM"));
			crepository.save(new Category("AG"));
			
			brepository.save(new Colorlist(01, "Ferrari Red" , 2 ,crepository.findByName("CG").get(0)));
			brepository.save(new Colorlist(02, "Coffe Bean", 0 , crepository.findByName("DG").get(0)));
			brepository.save(new Colorlist(03, "Mom", 1, crepository.findByName("GG").get(0)));
			
			user user1 = new user("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			user user2 = new user("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Get a list of colors available");
			for (Colorlist colors : brepository.findAll()) {
				log.info(colors.toString());
			}};}}
