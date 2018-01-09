package hello;

import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {

    @Autowired
    UserRepository repo;

    @Autowired
    UserService service;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("UserEntity", repo.findAll());
        return "index";
    }

    @RequestMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public @ResponseBody List<UserEntity> getUsers() {
        return repo.findAll();
    }

    @RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public @ResponseBody UserEntity getUser(@RequestParam String username) {
        return service.findByUserame(username);
    }

}