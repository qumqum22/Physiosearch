package com.rehabilitation.demo;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.AddressRepository;
import com.rehabilitation.demo.repository.PhonesRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserDataRepository userDataRepository, PhonesRepository phonesRepository, AddressRepository addressRepository)
    {
        return args-> {
            UserData user1 = new UserData("Piotr", "Pierwszy",null,"inż.","ops",22,"Male","username", "password","abra@abra.pl");
            UserData user2 = new UserData("Anna", "Druga","https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg","inż.",
                    "ops",22,"Male","username1","passowordpl", "mail@123.pl");

            Address address1 = new Address("Krakow", "Armii Krajowej", "25", "30-150, Kraków");
            Address address2 = new Address("Krakow", "Winnicka", "40", "30-394, Kraków");
            Address address3 = new Address("Krakow", "Królowej Jadwigi", "11", "32-089, Biały");

            //add address references user
            user1.getAddress().add(address1);
            user1.getAddress().add(address2);
            user2.getAddress().add(address2);
            user2.getAddress().add(address3);
//            //add user references address
            address1.getUserdata().add(user1);
            address2.getUserdata().add(user1);
            address2.getUserdata().add(user2);
            address3.getUserdata().add(user2);
        log.info("Preloading " + userDataRepository.save(user1));
        log.info("Preloading " + userDataRepository.save(user2));
        log.info("Preloading " + userDataRepository.save(new UserData("Michał", "Byczek",null,"dr",
                    "ops",22,"Male","username2","passowordpl", "michal@o2.pl")));
        log.info("Preloading " + userDataRepository.save(new UserData("Marian", "Doniczka","https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg","mgr inż.",
                "ops",22,"Male","username3","passowordpl", "marian.doniczka@gmail.com")));
        log.info("Preloading " + userDataRepository.save(new UserData("Krystyna", "Pewniak","https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg","mgr inż.",
                "ops",22,"Male","username4","passowordpl", "krystyna24@wp.pl")));
        log.info("Preloading " + userDataRepository.save(new UserData("Jan", "Jeste",null,"inż.",
                "ops",22,"Male","username5","passowordpl", "JesteJan1@o2.pl")));
        log.info("Preloading " + userDataRepository.save(new UserData("Tadeusz", "Cotr",null,"inż.",
                    "ops",22,"Male","username6","passowordpl", "Tadeusz.cotr@interia.pl")));
            log.info("Preloading " + userDataRepository.save(new UserData("Kinga", "Lepszy",null,null,
                    "ops",22,"Male","username7","passowordpl", "kinlep@wp.pl")));
        log.info("Preloading " + phonesRepository.save(new Phones("931299999", user1)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", user1)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", user1)));
        log.info("Preloading " + phonesRepository.save(new Phones("996456549", user1)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", user2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", user2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456789999", user2)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", user2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", user2)));
        log.info("Preloading " + addressRepository.save(address1));
        log.info("Preloading " + addressRepository.save(address2));
        log.info("Preloading " + addressRepository.save(address3));
        };

    }
}

