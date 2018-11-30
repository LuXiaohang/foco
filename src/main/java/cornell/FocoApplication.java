package cornell;

import cornell.controller.FoodInfoController;
import cornell.dao.FoodInfo;
import cornell.dao.FoodInfoRepository;
import cornell.dao.ProfileFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

import java.io.File;

@SpringBootApplication
public class FocoApplication implements CommandLineRunner {

    @Autowired
    private ProfileFormRepository userRepository;

    @Autowired
    private FoodInfoRepository foodInfoRepository;

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(FocoApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

    @Override
    public void run(String... strings) throws Exception{
        new File(FoodInfoController.uploadDirectory).mkdir();
        foodInfoRepository.save(new FoodInfo("Yee","Sandwich and bacon","Bloomberg auditorium","Seminar food left over.","food3.jpg"));
        foodInfoRepository.save(new FoodInfo("Shawn","Bread","tata second floor","Breakfast for sprint, come get it.","food2.jpg"));
    }
}
