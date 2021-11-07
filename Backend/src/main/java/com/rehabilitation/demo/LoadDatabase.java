package com.rehabilitation.demo;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserAccount;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.AddressRepository;
import com.rehabilitation.demo.repository.PhonesRepository;
import com.rehabilitation.demo.repository.UserAccountRepository;
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
    CommandLineRunner initDatabase(UserAccountRepository userAccountRepository, UserDataRepository userDataRepository, PhonesRepository phonesRepository, AddressRepository addressRepository)
    {
        return args-> {
            UserData userData1 = new UserData("inż.", "Piotr", "Pierwszy","Male", null, null, "Moj krotki opis");
            UserData userData2 = new UserData("inż.", "Agnieszka", "Druga","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu");
            UserData userData3 = new UserData("dr", "Michał", "Byczek","Male", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu");
            UserData userData4 = new UserData("mgr inż.", "Marian", "Doniczka","Male", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu");
            UserData userData5 = new UserData("dr", "Krystyna", "Pewniak","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu");
            UserData userData6 = new UserData("inż.", "Jan", "Jeste","Male", null, null, "Witam w moim profilu");
            UserData userData7 = new UserData("inż.", "Tadeusz", "Cotr","Male", null, null, "Witam w moim profilu");
            UserData userData8 = new UserData(null, "Kinga", "Lepszy","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu");
            UserAccount userAccount1 = new UserAccount("piotr.pierwszy@example.com", "password", "123", "123", userData1);
            UserAccount userAccount2 = new UserAccount("agnieszka.druga@example.com", "password123", "123", "123", userData2);
            UserAccount userAccount3 = new UserAccount("michal@o2.pl", "passowordpl", "123", "123", userData3);
            UserAccount userAccount4 = new UserAccount("marian.doniczka@gmail.com", "passoword1l", "123", "123", userData4);
            UserAccount userAccount5 = new UserAccount("krystyna24@wp.pl", "passowordpl", "123", "123", userData5);
            UserAccount userAccount6 = new UserAccount("JesteJan1@o2.pl", "passowordpl", "123", "123", userData6);
            UserAccount userAccount7 = new UserAccount("tcotr@interia.pl", "passowordpl", "123", "123", userData7);
            UserAccount userAccount8 = new UserAccount("kinlep@wp.pl", "passowordpl", "123", "123", userData8);

            Address address1 = new Address("Krakow", "Armii Krajowej", "25", "30-150, Kraków");
            Address address2 = new Address("Krakow", "Winnicka", "40", "30-394, Kraków");
            Address address3 = new Address("Krakow", "Królowej Jadwigi", "11", "32-089, Biały");

//            userData1.getAddress().add(address1);
//            userData1.getAddress().add(address2);
//            userData2.getAddress().add(address2);
//            userData2.getAddress().add(address3);
//
//     //add user references address
//
//            address1.getUserdata().add(userData1);
//            address2.getUserdata().add(userData1);
//            address2.getUserdata().add(userData2);
//            address3.getUserdata().add(userData2);

            savePerson(userAccount1, userData1, userAccountRepository, userDataRepository);
            savePerson(userAccount2, userData2, userAccountRepository, userDataRepository);
            savePerson(userAccount3, userData3, userAccountRepository, userDataRepository);
            savePerson(userAccount4, userData4, userAccountRepository, userDataRepository);
            savePerson(userAccount5, userData5, userAccountRepository, userDataRepository);
            savePerson(userAccount6, userData6, userAccountRepository, userDataRepository);
            savePerson(userAccount7, userData7, userAccountRepository, userDataRepository);
            savePerson(userAccount8, userData8, userAccountRepository, userDataRepository);


        log.info("Preloading " + phonesRepository.save(new Phones("931299999", userData1)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData1)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData1)));
        log.info("Preloading " + phonesRepository.save(new Phones("996456549", userData1)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456789999", userData2)));
        log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData2)));
        log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData2)));
        log.info("Preloading " + addressRepository.save(address1));
        log.info("Preloading " + addressRepository.save(address2));
        log.info("Preloading " + addressRepository.save(address3));

        };
    }
    private void savePerson(UserAccount ua, UserData ud, UserAccountRepository uaRepository, UserDataRepository udRepository){
        log.info("Preloading " + uaRepository.save(ua));
        log.info("Preloading " + udRepository.save(ud));
    }
}

