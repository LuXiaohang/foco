package cornell.controller;

import cornell.dao.ProfileForm;
import cornell.dao.ProfileFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FocoController{

    @Autowired
    private ProfileFormRepository userRepository;

    @RequestMapping("/login.html")
    public String login(ProfileForm profileForm){ return "login"; }

    @RequestMapping("/index.html")
    public String index(Model model){
        model.addAttribute("message","Login");
        return "index";
    }

    @RequestMapping(value = "/loginIndex",method = RequestMethod.POST)
    public String displayProfile(ProfileForm profileForm,Model model){
        String username = profileForm.getUsername();
        String password = profileForm.getPassword();
        model.addAttribute("message",username);
        return "index";
    }
}