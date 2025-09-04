package Controllers;

@Controller
public class LanguageController {

    @GetMapping("/changeLanguage")
    public String changeLanguage(HttpServletRequest request){
        return "redirect:"+ request.getHeader("referer");
    }
}
