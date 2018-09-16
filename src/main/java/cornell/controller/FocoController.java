package cornell.controller;

import cornell.dao.ProfileForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FocoController{
    @RequestMapping("/login.html")
    public String login(ProfileForm profileForm){ return "login"; }

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String displayProfile(ProfileForm profileForm,Model model){
        model.addAttribute("message",profileForm.getUsername()+profileForm.getPassword());
        return "resultPage";
    }
}