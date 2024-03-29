package demo.hello.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Docker") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

}
