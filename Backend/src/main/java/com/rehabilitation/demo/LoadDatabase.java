package com.rehabilitation.demo;

import com.rehabilitation.demo.models.*;
import com.rehabilitation.demo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

//@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    //@Bean
    CommandLineRunner initDatabase(UserAccountRepository userAccountRepository,
                                   UserDataRepository userDataRepository,
                                   PhonesRepository phonesRepository,
                                   ClinicRepository clinicRepository,
                                   UserRightsRepository userRightsRepository)
    {
        return args-> {
            saveRights(userRightsRepository);

            UserData userData1 = new UserData("inż.", "Piotr", "Pierwszy","Male", null, null, "Moj krotki opis",null);
            UserData userData2 = new UserData("inż.", "Agnieszka", "Druga","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu",null);
            UserData userData3 = new UserData("dr", "Michał", "Byczek","Male", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu",null);
//            UserData userData4 = new UserData("mgr inż.", "Marian", "Doniczka","Male", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu",null);
//            UserData userData5 = new UserData("dr", "Krystyna", "Pewniak","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu",null);
//            UserData userData6 = new UserData("inż.", "Jan", "Jeste","Male", null, null, "Witam w moim profilu",null);
//            UserData userData7 = new UserData("inż.", "Tadeusz", "Cotr","Male", null, null, "Witam w moim profilu",null);
//            UserData userData8 = new UserData(null, "Kinga", "Lepszy","Female", null, "https://cdn.wallpapersafari.com/95/5/3rRDsg.jpg", "Witam w moim profilu",null);
            UserAccount userAccount1 = new UserAccount("piotr.pierwszy@example.com", "password", "123", userData1);
            UserAccount userAccount2 = new UserAccount("agnieszka.druga@example.com", "password123", "123", userData2);
            UserAccount userAccount3 = new UserAccount("michal@o2.pl", "passowordpl", "123", userData3);
//            UserAccount userAccount4 = new UserAccount("marian.doniczka@gmail.com", "passoword1l", "123", "123", userData4);
//            UserAccount userAccount5 = new UserAccount("krystyna24@wp.pl", "passowordpl", "123", "123", userData5);
//            UserAccount userAccount6 = new UserAccount("JesteJan1@o2.pl", "passowordpl", "123", "123", userData6);
//            UserAccount userAccount7 = new UserAccount("tcotr@interia.pl", "passowordpl", "123", "123", userData7);
//            UserAccount userAccount8 = new UserAccount("kinlep@wp.pl", "passowordpl", "123", "123", userData8);

            Clinic clinic1 = new Clinic("Krakow","REHAMAX", "Armii Krajowej", "25", "30-150, Kraków");
            Clinic clinic2 = new Clinic("Krakow", "PANAMEDIC","Winnicka", "40", "30-394, Kraków");
            Clinic clinic3 = new Clinic("Krakow", "SUPERHIT","Królowej Jadwigi", "11", "32-089, Biały");


            // duplikuje dane w tabeli z prawami
            userData1.getRights().add(new UserRights("USER"));
            userData1.getRights().add(new UserRights("MODERATOR"));
            userData1.getRights().add(new UserRights("ADMINISTRATOR"));

//            userData1.getClinics().add(clinic1);
//            userData1.getClinics().add(clinic2);
//            userData2.getClinics().add(clinic2);
//            userData2.getClinics().add(clinic3);
//
//     //add user references address
//
//            clinic1.getUserdata().add(userData1);
//            clinic2.getUserdata().add(userData1);
//            clinic2.getUserdata().add(userData2);
//            clinic3.getUserdata().add(userData2);

            savePerson(userAccount1, userData1, userAccountRepository, userDataRepository);
            savePerson(userAccount2, userData2, userAccountRepository, userDataRepository);
            savePerson(userAccount3, userData3, userAccountRepository, userDataRepository);
//            savePerson(userAccount4, userData4, userAccountRepository, userDataRepository);
//            savePerson(userAccount5, userData5, userAccountRepository, userDataRepository);
//            savePerson(userAccount6, userData6, userAccountRepository, userDataRepository);
//            savePerson(userAccount7, userData7, userAccountRepository, userDataRepository);
//            savePerson(userAccount8, userData8, userAccountRepository, userDataRepository);

//
//            log.info("Preloading " + phonesRepository.save(new Phones("931299999", userData1)));
//            log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData1)));
//            log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData1)));
//            log.info("Preloading " + phonesRepository.save(new Phones("996456549", userData1)));
//            log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData2)));
//            log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData2)));
//            log.info("Preloading " + phonesRepository.save(new Phones("456789999", userData2)));
//            log.info("Preloading " + phonesRepository.save(new Phones("956478659", userData2)));
//            log.info("Preloading " + phonesRepository.save(new Phones("456478659", userData2)));
//            log.info("Preloading " + addressRepository.save(clinic1));
//            log.info("Preloading " + addressRepository.save(clinic2));
//            log.info("Preloading " + addressRepository.save(clinic3));

        };
    }
    private void savePerson(UserAccount ua, UserData ud, UserAccountRepository uaRepository, UserDataRepository udRepository){
        log.info("Preloading " + uaRepository.save(ua));
        log.info("Preloading " + udRepository.save(ud));
    }

    private void saveRights(UserRightsRepository userRightsRepository){
        UserRights userUser = new UserRights("USER");
        UserRights userPhysio = new UserRights("PHYSIO");
        UserRights userModerator = new UserRights("MODERATOR");
        UserRights userAdministrator = new UserRights("ADMINISTRATOR");
        userRightsRepository.save(userUser);
        userRightsRepository.save(userPhysio);
        userRightsRepository.save(userModerator);
        userRightsRepository.save(userAdministrator);

    }
}

