package cornell.controller;

import cornell.dao.FoodComment;
import cornell.dao.FoodCommentRepository;
import cornell.dao.FoodInfo;
import cornell.dao.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class FoodInfoController {
    @Autowired
    private FoodInfoRepository foodInfoRepository;

    @Autowired
    private FoodCommentRepository foodCommentRepository;

    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads/";

    @RequestMapping("/foodInfoForm")
    public String foodInfoForm(FoodInfo foodInfo){
        return "uploadFoodInfo";
    }

    @RequestMapping(value = "/uploadFoodInfo", method = RequestMethod.POST)
    public String uploadFoodInfo(@ModelAttribute FoodInfo foodInfo, @RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()) {
            return "uploadFoodInfo";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadDirectory + file.getOriginalFilename());
            Files.write(path, bytes);
            foodInfo.setImg(file.getOriginalFilename());
            System.out.println(path.toString());
            foodInfo.setTime(new Timestamp(System.currentTimeMillis()));
            foodInfoRepository.save(foodInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return displayFoodInfo(model);
    }

    @RequestMapping("/displayFoodInfo")
    public String displayFoodInfo(Model model){
        Timestamp endtime = new Timestamp(System.currentTimeMillis());
        Timestamp starttime = new Timestamp(endtime.getTime()-86400000*2);
        List<FoodInfo> foods = foodInfoRepository.findAllByTimeBetweenOrderByTimeDesc(starttime,endtime);
        List<List<FoodInfo>> foodslists = new LinkedList<List<FoodInfo>>();
        List<FoodInfo> tmpList = new LinkedList<>();
        for(int i=0;i<foods.size();i++){
            tmpList.add(foods.get(i));
            if(tmpList.size()==3||i+1==foods.size()){
                foodslists.add(new ArrayList<>(tmpList));
                tmpList.clear();
            }

        }
        model.addAttribute("foodsLists",foodslists);
        return "foodInfo";
    }

    @RequestMapping(value = "image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File(uploadDirectory + imageName);
        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value="detail/{foodId}")
    public String getDetail(@PathVariable(value="foodId") Long id, Model model,FoodComment foodComment){
        FoodInfo foodInfo = foodInfoRepository.findAllById(id).get(0);
        List<FoodComment> foodComments = foodCommentRepository.findAllByFoodIdOrderByTimeDesc(id);
        model.addAttribute("foodInfo",foodInfo);
        model.addAttribute("foodComments",foodComments);
        return "foodDetail";
    }

    @RequestMapping(value="insertFoodComment/{foodId}")
    public String insertComment(@PathVariable(value="foodId")Long id, @ModelAttribute FoodComment comment, Model model, FoodComment foodComment){
        comment.setFoodId(id);
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        foodCommentRepository.save(comment);
        return getDetail(id,model,foodComment);
    }

}
