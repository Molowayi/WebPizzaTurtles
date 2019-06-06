package be.intecbrussel.webpizzaturtlemolowayi.controllers;

import be.intecbrussel.webpizzaturtlemolowayi.services.tortoise.Tortoise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = {"/", "welcome"})
    public String handleWelcome(Model model) {
        model.addAttribute("michi", numberOfEatenPizzas("michelangelo"));
        model.addAttribute("dona", numberOfEatenPizzas("donatello"));
        model.addAttribute("leo", numberOfEatenPizzas("leonardo"));
        model.addAttribute("raph", numberOfEatenPizzas("raphael"));
        return "welcome";
    }

    private int numberOfEatenPizzas(String tortoiseMethod) {
        Tortoise tortoise = applicationContext.getBean(tortoiseMethod, Tortoise.class);
        return tortoise.getEatenPizzas().size();
    }

    @RequestMapping("michelangelo")
    public String handleMichelango(HttpServletRequest request, Model model) {
        buildTheModel(model, "michelangelo");
        return "michelangelo";
    }

    @RequestMapping("donatello")
    public String handleDonatello(HttpServletRequest request, Model model) {
        buildTheModel(model, "donatello");
        return "donatello";
    }


    @RequestMapping("leonardo")
    public String handleLeonardo(HttpServletRequest request, Model model) {
        buildTheModel(model, "leonardo");
        return "leonardo";
    }

    @RequestMapping("raphael")
    public String handleRahael(HttpServletRequest request, Model model) {
        buildTheModel(model, "raphael");
        return "raphael";
    }

    private void buildTheModel(Model model, String beanMethod) {
        Tortoise tortoise = applicationContext.getBean(beanMethod, Tortoise.class);
        model.addAttribute("tortoise", tortoise);
        model.addAttribute("totalEatenPizzas", tortoise.getEatenPizzas().size());
    }

    @RequestMapping(value = {"raphael", "leonardo", "michelangelo", "donatello"}, method = RequestMethod.POST)
    public String handlePauseAndResumeOfThreads(Model model, HttpServletRequest request,
                                                @RequestParam("pauseOfResume") String pauseOfResume) throws InterruptedException {

        String beansName = request.getServletPath().substring(1);
        Tortoise tortoise = applicationContext.getBean(beansName, Tortoise.class);
        buildTheModel(model, beansName);
        if (pauseOfResume.equalsIgnoreCase("pause")) {
            tortoise.setPause(true);
            model.addAttribute("pauseMessage", tortoise.getName()
                    + " takes a pause until you push the Resume button.");
        } else if (pauseOfResume.equalsIgnoreCase("resume")) {
            tortoise.setPause(false);
            model.addAttribute("resumeMessage", tortoise.getName()
                    + " can keep on eating. Pause finished.");
        }
        return request.getServletPath();
    }

}
