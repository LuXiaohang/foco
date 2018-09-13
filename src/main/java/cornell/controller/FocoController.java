package cornell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FocoController{
    @RequestMapping("/hello")
    public String hello(@RequestParam("name")String webName, Model model){
        model.addAttribute("message","Hello, This is "+webName);
        return "resultPage";
    }

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}