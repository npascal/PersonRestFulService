package org.pascalot.Controller;

import org.pascalot.restService.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hamisu on 12/2/15.
 */
@Controller
@RequestMapping("/")
public class PeopleController
{

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "people.form", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws IOException
    {
        return "redirect:people.form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doPage(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("people");
        modelAndView.addObject("refresh", new Refresh("people.form", 60, request, response));
        return modelAndView;
    }

    @RequestMapping(value = "index.form", method = RequestMethod.GET)
    public String getIndexJSP(ModelMap model)
    {
        model.addAttribute("message", "Displaying the Index.jsp page");
        return "index";
    }

    @RequestMapping(value = "refresh.form", method = RequestMethod.GET)
    public String goGet()
    {
        return "redirect:people.form";
    }


    @RequestMapping(value = "people.form", method = RequestMethod.GET)
    public ModelAndView getStateJSP(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ModelAndView model = new ModelAndView("people");
        return model;
    }

    public void setPeopleService(PeopleService peopleService)
    {
        this.peopleService = peopleService;
    }
}
