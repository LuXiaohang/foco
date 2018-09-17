package cornell;

import cornell.dao.ProfileForm;
import cornell.dao.ProfileFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FocoApplication implements CommandLineRunner {

    @Autowired
    private ProfileFormRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FocoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception{
        userRepository.save(new ProfileForm("owner","h2345"));
        userRepository.save(new ProfileForm("owner1","h1234"));
        userRepository.save(new ProfileForm("owner2","h1235"));
        userRepository.save(new ProfileForm("owner3","h1245"));
        userRepository.save(new ProfileForm("owner4","h1345"));
    }
}
