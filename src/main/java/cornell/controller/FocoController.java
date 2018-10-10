package cornell.controller;

import java.util.Optional;
import java.util.List;
import cornell.dao.ProfileForm;
import cornell.dao.ProfileFormRepository;
import cornell.dao.Suggestion;
import cornell.dao.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FocoController{

    @Autowired
    private ProfileFormRepository userRepository;

    @Autowired
    private SuggestionRepository suggestionRepository;

//    @RequestMapping("/signup")
//    public String signup(ProfileForm profileForm){ return "signup"; }
//
//    @RequestMapping("/login")
//    public String login(ProfileForm profileForm){ return "login"; }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("message","Suggest");
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("message","Suggest");
        return "About";
    }

    @RequestMapping("/displaySuggestion")
    public String displaySuggestion(Model model){
        List<Suggestion> suggestions = suggestionRepository.findAll();
        model.addAttribute("suggestions",suggestions);
        return "displaySuggestion";
    }

    @RequestMapping("/suggestion")
    public String suggestionForm(Suggestion suggestion, Model model){
        model.addAttribute("message","Suggest");
        return "suggestion";
    }

    @RequestMapping(value = "/insertSuggestion", method = RequestMethod.POST)
    public String insertSuggestion(Suggestion suggestion, Model model){
        suggestionRepository.save(suggestion);
        model.addAttribute("message","Thanks");
        return "index";
    }

//    @RequestMapping(value = "/loginSuccessAdmin",method = RequestMethod.POST)
//    public String loginSuccess(ProfileForm profileForm,Model model){
//        String username = profileForm.getUsername();
//        String password = profileForm.getPassword();
//        Optional<ProfileForm> user = userRepository.findById(username);
//        if(user.isPresent()&&user.get().getPassword().equals(password)){
//            model.addAttribute("message",username);
//            return "index";
//        }
//        return "404";
//    }

}