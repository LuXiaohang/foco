package cornell;

import cornell.controller.FoodInfoController;
import cornell.dao.FoodInfo;
import cornell.dao.FoodInfoRepository;
import cornell.dao.ProfileForm;
import cornell.dao.ProfileFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.File;

@SpringBootApplication
@ComponentScan({"cornell","cornell.controller"})
public class FocoApplication implements CommandLineRunner {

    @Autowired
    private ProfileFormRepository userRepository;

    @Autowired
    private FoodInfoRepository foodInfoRepository;

    public static void main(String[] args) {
        SpringApplication.run(FocoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception{
        new File(FoodInfoController.uploadDirectory).mkdir();
        userRepository.save(new ProfileForm("owner","ownerhijack"));
        foodInfoRepository.save(new FoodInfo("name1","foodType","location","description","zhuzhu.jpeg"));
        foodInfoRepository.save(new FoodInfo("name2","foodType","location","description","zhuzhu.jpeg"));
        foodInfoRepository.save(new FoodInfo("name3","foodType","location","description","zhuzhu.jpeg"));
        foodInfoRepository.save(new FoodInfo("name4","foodType","location","description","zhuzhu.jpeg"));
        foodInfoRepository.save(new FoodInfo("name5","foodType","location","description","zhuzhu.jpeg"));
        foodInfoRepository.save(new FoodInfo("name6","foodType","location","description","zhuzhu.jpeg"));
    }
}
