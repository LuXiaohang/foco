package cornell.controller;

import java.util.Optional;
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

    @RequestMapping("/signup")
    public String signup(ProfileForm profileForm){ return "signup"; }

    @RequestMapping("/login")
    public String login(ProfileForm profileForm){ return "login"; }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("message","Login");
        return "index";
    }

    @RequestMapping(value = "/loginSuccess",method = RequestMethod.POST)
    public String loginSuccess(ProfileForm profileForm,Model model){
        String username = profileForm.getUsername();
        String password = profileForm.getPassword();
        Optional<ProfileForm> user = userRepository.findById(username);
        if(user.isPresent()&&user.get().getPassword().equals(password)){
            model.addAttribute("message",username);
            return "index";
        }
        return "404";
    }

    @RequestMapping(value = "/signupSuccess",method = RequestMethod.POST)
    public String signupSuccess(ProfileForm profileForm,Model model){
        String username = profileForm.getUsername();
        String password = profileForm.getPassword();
        Optional<ProfileForm> user = userRepository.findById(username);
        if(user.isPresent()) {
            return "signup";
        }
        userRepository.save(new ProfileForm(username,password));
        model.addAttribute("message",username);
        return "index";
    }
}